package gianni_bussoletti.beu2s3exam.services;

import gianni_bussoletti.beu2s3exam.DTO.LoginDTO;
import gianni_bussoletti.beu2s3exam.entites.Cliente;
import gianni_bussoletti.beu2s3exam.entites.CreatoreEventi;
import gianni_bussoletti.beu2s3exam.exceptions.UnathorizedException;
import gianni_bussoletti.beu2s3exam.security.TokenTools;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class AuthService {

    private ClienteService clienteService;
    private TokenTools tController;
    private PasswordEncoder bcrypt;
    private CreatoreService creatoreService;

    public String credControlGenerateToken(@RequestBody LoginDTO body) {
        Cliente found = this.clienteService.findByEmail(body.mail());
        if (this.bcrypt.matches(body.password(), found.getPassword())) {
            return this.tController.tokenGeneratorClient(found);
        } else throw new UnathorizedException("La password è sbagliata");
    }

    public String credControlGenerateTokenCreator(@RequestBody LoginDTO body) {
        CreatoreEventi found = this.creatoreService.findByEmail(body.mail());
        if (this.bcrypt.matches(body.password(), found.getPassword())) {
            return this.tController.tokenGeneratorCreator(found);
        } else throw new UnathorizedException("La password è sbagliata");
    }
}
