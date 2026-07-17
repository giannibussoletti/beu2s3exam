package gianni_bussoletti.beu2s3exam.controllers;

import gianni_bussoletti.beu2s3exam.DTO.EventoDTO;
import gianni_bussoletti.beu2s3exam.DTO.EventoResponseDTO;
import gianni_bussoletti.beu2s3exam.entites.CreatoreEventi;
import gianni_bussoletti.beu2s3exam.entites.Evento;
import gianni_bussoletti.beu2s3exam.exceptions.ValidationException;
import gianni_bussoletti.beu2s3exam.services.EventoService;
import lombok.AllArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/eventi")
@AllArgsConstructor
public class EventiController {

    private EventoService eventoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyAuthority('CREATORE_EVENTI')")
    public EventoResponseDTO save(@AuthenticationPrincipal CreatoreEventi creatoreEventi, @RequestBody @Validated EventoDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            List<String> errorsMessage = validation.getFieldErrors().stream().map((DefaultMessageSourceResolvable::getDefaultMessage)).toList();
            throw new ValidationException(errorsMessage);
        }
        Evento save = this.eventoService.save(body, creatoreEventi);
        return new EventoResponseDTO("Evento salvato correttamente", save.getId(), LocalDateTime.now());
    }


}
