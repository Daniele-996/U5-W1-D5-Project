package danieleSanzari.u5w1d5project.services;

import danieleSanzari.u5w1d5project.entities.PostazioneAziendale;
import danieleSanzari.u5w1d5project.entities.Prenotazione;
import danieleSanzari.u5w1d5project.entities.Utente;
import danieleSanzari.u5w1d5project.exceptions.NotFoundException;
import danieleSanzari.u5w1d5project.exceptions.ValidationException;
import danieleSanzari.u5w1d5project.repositories.PostazioneRepo;
import danieleSanzari.u5w1d5project.repositories.PrenotazioneRepo;
import danieleSanzari.u5w1d5project.repositories.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepo prenotazioneRepo;
    @Autowired
    private PostazioneRepo postazioneRepo;
    @Autowired
    private UtenteRepo utenteRepo;

    public Prenotazione creaPrenotazione(Long idUtente, Long idPostazione, LocalDate data) {
        Utente utente = utenteRepo.findById(idUtente).orElseThrow(() -> new NotFoundException(idUtente));
        PostazioneAziendale postazione = postazioneRepo.findById(idPostazione).orElseThrow(() -> new NotFoundException(idPostazione));

        boolean postazioneOccupata = prenotazioneRepo.existsByPostazioneAndData(postazione, data);
        if (postazioneOccupata) {
            throw new ValidationException("La postazione è già stata assegnata per quella data!");
        }
        boolean utenteHaGiaPrenotazioniQuelGiorno = prenotazioneRepo.existsByUtenteAndData(utente, data);
        if (utenteHaGiaPrenotazioniQuelGiorno) {
            throw new ValidationException("L'utente ha già una prenotazione per quel giorno!");
        }
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setPostazioneAziendale(postazione);
        prenotazione.setDataPrenotazione(data);
        return prenotazioneRepo.save(prenotazione);
    }

    public List<Prenotazione> findPrenotazioniByUtente(Long idUtente) {
        return prenotazioneRepo.findByUtenteId(idUtente);
    }
}
