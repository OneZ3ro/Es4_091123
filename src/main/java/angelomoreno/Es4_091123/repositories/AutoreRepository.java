package angelomoreno.Es4_091123.repositories;

import angelomoreno.Es3_081123.entities.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Long> {
    Optional<Autore> findByEmail(String email);
}
