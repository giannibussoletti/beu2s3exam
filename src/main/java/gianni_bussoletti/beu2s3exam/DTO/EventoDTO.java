package gianni_bussoletti.beu2s3exam.DTO;

import java.time.LocalDate;

public record EventoDTO(
        String nome,
        String descrizione,
        String luogo,
        LocalDate data,
        int postiDisponibili
) {
}
