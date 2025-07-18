package danieleSanzari.u5w1d5project.repositories;

import danieleSanzari.u5w1d5project.entities.PostazioneAziendale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostazioneRepo extends JpaRepository<PostazioneAziendale, Long> {
}
