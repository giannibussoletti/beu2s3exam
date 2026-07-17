package gianni_bussoletti.beu2s3exam.services;

import gianni_bussoletti.beu2s3exam.DTO.ClienteDTO;
import gianni_bussoletti.beu2s3exam.entites.Cliente;
import gianni_bussoletti.beu2s3exam.exceptions.EmailExistsInDBException;
import gianni_bussoletti.beu2s3exam.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;


    public Cliente save(ClienteDTO body) {
        if (this.clienteRepository.existsByMail(body.mail()))
            throw new EmailExistsInDBException("L'email è già presente nel Database");

        Cliente newCliente = new Cliente(body.name(), body.surname(), body.mail(), body.password(), body.birthDate());
        return this.clienteRepository.save(newCliente);

    }

}
