package gianni_bussoletti.beu2s3exam.services;

import gianni_bussoletti.beu2s3exam.DTO.CreatoreDTO;
import gianni_bussoletti.beu2s3exam.entites.CreatoreEventi;
import gianni_bussoletti.beu2s3exam.exceptions.EmailExistsInDBException;
import gianni_bussoletti.beu2s3exam.exceptions.NotFoundException;
import gianni_bussoletti.beu2s3exam.repositories.CreatoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CreatoreService {

    private CreatoreRepository creatoreRepository;
    private PasswordEncoder bcrypt;


    public CreatoreEventi save(CreatoreDTO body) {
        if (this.creatoreRepository.existsByMail(body.mail()))
            throw new EmailExistsInDBException("L'email è già presente nel Database");

        CreatoreEventi newCreatore = new CreatoreEventi(body.name(), body.surname(), body.mail(), this.bcrypt.encode(body.password()));
        return this.creatoreRepository.save(newCreatore);

    }

    public CreatoreEventi findByEmail(String mail) {
        return this.creatoreRepository.findCreatoreEventiByMail(mail).orElseThrow(() -> new NotFoundException("L'email non è stata trovata"));
    }

    public CreatoreEventi findById(UUID id) {
        return this.creatoreRepository.findCreatoreEventiById(id).orElseThrow(() -> new NotFoundException("Creatore eventi non trovato"));
    }
}