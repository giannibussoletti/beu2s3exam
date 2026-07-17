package gianni_bussoletti.beu2s3exam.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @Email(message = "L'email non rispetta i requisiti necessari")
        @NotBlank(message = "il campo non può essere lasciato vuoto")
        String mail,
        @NotBlank(message = "Il campo non può essere lasciato vuoto")
        String password) {
}