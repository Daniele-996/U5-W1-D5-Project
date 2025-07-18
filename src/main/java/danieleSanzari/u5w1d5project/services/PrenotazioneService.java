package danieleSanzari.u5w1d5project.services;

import danieleSanzari.u5w1d5project.repositories.PostazioneRepo;
import danieleSanzari.u5w1d5project.repositories.PrenotazioneRepo;
import danieleSanzari.u5w1d5project.repositories.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepo prenotazioneRepo;
    @Autowired
    private PostazioneRepo postazioneRepo;
    @Autowired
    private UtenteRepo utenteRepo;


}
