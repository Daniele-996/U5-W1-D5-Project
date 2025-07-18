package danieleSanzari.u5w1d5project.runners;

import danieleSanzari.u5w1d5project.services.EdificioService;
import danieleSanzari.u5w1d5project.services.PostazioneService;
import danieleSanzari.u5w1d5project.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {

    }
}
