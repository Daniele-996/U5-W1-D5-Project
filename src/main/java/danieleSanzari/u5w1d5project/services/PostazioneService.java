package danieleSanzari.u5w1d5project.services;

import danieleSanzari.u5w1d5project.entities.PostazioneAziendale;
import danieleSanzari.u5w1d5project.enums.TipoPostazione;
import danieleSanzari.u5w1d5project.exceptions.NotFoundException;
import danieleSanzari.u5w1d5project.repositories.PostazioneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepo postazioneRepo;

    public PostazioneAziendale savePostazione(PostazioneAziendale postazioneAziendale) {
        return postazioneRepo.save(postazioneAziendale);
    }

    public PostazioneAziendale findById(Long id) {
        return postazioneRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public List<PostazioneAziendale> ricercaPerTipoEPerCitta(TipoPostazione tipoPostazione, String citta) {
        return postazioneRepo.findByTipoAndEdificio_Citta(tipoPostazione, citta);
    }
}
