package danieleSanzari.u5w1d5project.repositories;

import danieleSanzari.u5w1d5project.entities.PostazioneAziendale;
import danieleSanzari.u5w1d5project.entities.Prenotazione;
import danieleSanzari.u5w1d5project.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepo extends JpaRepository<Prenotazione, Long> {
    boolean existsByPostazioneAziendaleAndData(PostazioneAziendale postazioneAziendale, LocalDate data);

    boolean existsByUtenteAndData(Utente utente, LocalDate data);

    List<Prenotazione> findByUtenteId(Long utenteId);
}
