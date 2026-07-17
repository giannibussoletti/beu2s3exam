package gianni_bussoletti.beu2s3exam.repositories;

import gianni_bussoletti.beu2s3exam.entites.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventoRepository extends JpaRepository<Evento, UUID> {

}
