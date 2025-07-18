package danieleSanzari.u5w1d5project.repositories;

import danieleSanzari.u5w1d5project.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
