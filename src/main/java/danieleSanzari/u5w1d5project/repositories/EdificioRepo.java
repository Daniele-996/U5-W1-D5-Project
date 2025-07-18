package danieleSanzari.u5w1d5project.repositories;

import danieleSanzari.u5w1d5project.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepo extends JpaRepository<Edificio, Long> {
}
