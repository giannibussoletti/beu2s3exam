package gianni_bussoletti.beu2s3exam.repositories;

import gianni_bussoletti.beu2s3exam.entites.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    boolean existsByMail(String email);

    Optional<Cliente> findClienteByMail(String mail);
}
