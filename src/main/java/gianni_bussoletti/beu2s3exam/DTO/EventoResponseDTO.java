package gianni_bussoletti.beu2s3exam.DTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventoResponseDTO(String message, UUID id, LocalDateTime createdAt) {
}
