package gianni_bussoletti.beu2s3exam.controllers;

import gianni_bussoletti.beu2s3exam.DTO.ClienteDTO;
import gianni_bussoletti.beu2s3exam.DTO.ClienteResponseDTO;
import gianni_bussoletti.beu2s3exam.entites.Cliente;
import gianni_bussoletti.beu2s3exam.exceptions.ValidationException;
import gianni_bussoletti.beu2s3exam.services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/clienti")
@AllArgsConstructor
public class ClienteController {

    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDTO save(@RequestBody @Validated ClienteDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            List<String> errosMessage = validation.getFieldErrors().stream().map((DefaultMessageSourceResolvable::getDefaultMessage)).toList();
            throw new ValidationException(errosMessage);
        }

        Cliente save = this.clienteService.save(body);
        return new ClienteResponseDTO("Cliente registrato correttamente", save.getId(), LocalDateTime.now());
    }

}
