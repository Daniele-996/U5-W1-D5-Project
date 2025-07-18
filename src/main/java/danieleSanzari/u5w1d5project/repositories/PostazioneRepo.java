package danieleSanzari.u5w1d5project.repositories;

import danieleSanzari.u5w1d5project.entities.PostazioneAziendale;
import danieleSanzari.u5w1d5project.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostazioneRepo extends JpaRepository<PostazioneAziendale, Long> {
    List<PostazioneAziendale> findByTipo(TipoPostazione tipoPostazione);

    List<PostazioneAziendale> findByTipoAndEdificio_Citta(TipoPostazione tipoPostazione, String citta);

}
