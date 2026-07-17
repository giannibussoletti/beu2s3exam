package gianni_bussoletti.beu2s3exam.controllers;

import gianni_bussoletti.beu2s3exam.DTO.LoginDTO;
import gianni_bussoletti.beu2s3exam.DTO.LoginResponseDTO;
import gianni_bussoletti.beu2s3exam.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthControllers {

    private final AuthService authService;

    @PostMapping("/login/clienti")
    public LoginResponseDTO loginClient(@RequestBody LoginDTO body) {
        String token = this.authService.credControlGenerateToken(body);
        return new LoginResponseDTO(token);
    }

    @PostMapping("/login/creatori")
    public LoginResponseDTO loginCreator(@RequestBody LoginDTO body) {
        String token = this.authService.credControlGenerateTokenCreator(body);
        return new LoginResponseDTO(token);
    }

}
