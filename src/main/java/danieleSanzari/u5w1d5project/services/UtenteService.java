package danieleSanzari.u5w1d5project.services;

import danieleSanzari.u5w1d5project.entities.Utente;
import danieleSanzari.u5w1d5project.exceptions.NotFoundException;
import danieleSanzari.u5w1d5project.exceptions.ValidationException;
import danieleSanzari.u5w1d5project.repositories.UtenteRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UtenteService {
    @Autowired
    private UtenteRepo utenteRepo;

    public Utente saveUtente(Utente utente) {
        if (utenteRepo.existsByUsername(utente.getUsername())) {
            throw new ValidationException("L'username :" + utente.getUsername() + " è già in uso!!");
        }
        if (utenteRepo.existsByEmail(utente.getEmail()))
            throw new ValidationException("Email " + utente.getEmail() + " già in uso");
        return utenteRepo.save(utente);
    }

    public Utente findById(Long id) {
        return utenteRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}
