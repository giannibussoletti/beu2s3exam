package gianni_bussoletti.beu2s3exam.controllers;

import gianni_bussoletti.beu2s3exam.DTO.CreatoreDTO;
import gianni_bussoletti.beu2s3exam.DTO.CreatoreResponseDTO;
import gianni_bussoletti.beu2s3exam.entites.CreatoreEventi;
import gianni_bussoletti.beu2s3exam.exceptions.ValidationException;
import gianni_bussoletti.beu2s3exam.services.CreatoreService;
import lombok.AllArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/creatori")
@AllArgsConstructor
public class CreatoreController {

    private CreatoreService creatoreService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatoreResponseDTO save(@RequestBody @Validated CreatoreDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            List<String> errorsMessage = validation.getFieldErrors().stream().map((DefaultMessageSourceResolvable::getDefaultMessage)).toList();
            throw new ValidationException(errorsMessage);
        }

        CreatoreEventi save = this.creatoreService.save(body);
        return new CreatoreResponseDTO("Creatore registrato correttamente", save.getId(), LocalDateTime.now());
    }

}
