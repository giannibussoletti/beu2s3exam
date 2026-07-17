package gianni_bussoletti.beu2s3exam.repositories;

import gianni_bussoletti.beu2s3exam.entites.CreatoreEventi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CreatoreRepository extends JpaRepository<CreatoreEventi, UUID> {

    boolean existsByMail(String email);

    Optional<CreatoreEventi> findCreatoreEventiByMail(String mail);

    Optional<CreatoreEventi> findCreatoreEventiById(UUID id);
}
