package danieleSanzari.u5w1d5project.services;

import danieleSanzari.u5w1d5project.entities.Edificio;
import danieleSanzari.u5w1d5project.exceptions.NotFoundException;
import danieleSanzari.u5w1d5project.repositories.EdificioRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EdificioService {
    @Autowired
    private EdificioRepo edificioRepo;

    public void saveEdificio(Edificio edificio) {
        edificioRepo.save(edificio);
    }

    public Edificio findById(Long id) {
        return edificioRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}

