package danieleSanzari.u5w1d5project;

import com.github.javafaker.Faker;
import danieleSanzari.u5w1d5project.entities.Edificio;
import danieleSanzari.u5w1d5project.entities.PostazioneAziendale;
import danieleSanzari.u5w1d5project.enums.TipoPostazione;
import danieleSanzari.u5w1d5project.services.EdificioService;
import danieleSanzari.u5w1d5project.services.PostazioneService;
import danieleSanzari.u5w1d5project.services.PrenotazioneService;
import danieleSanzari.u5w1d5project.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private PrenotazioneService prenotazioneService;
    @Autowired
    private UtenteService utenteService;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(Locale.ITALY);

     /*   List<Edificio> edifici = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Edificio newEdificio = new Edificio(
                    faker.address().cityName(),
                    faker.address().fullAddress(),
                    faker.commerce().department()
            );
            edificioService.saveEdificio(newEdificio);
            edifici.add(newEdificio);
        }
/*

        List<Utente> utenti = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            String firstName = faker.name().firstName().toLowerCase();
            String lastName = faker.name().lastName().toLowerCase();
            String email = firstName + "." + lastName + "@gmail.com";
            String nomeCompleto = faker.name().firstName() + " " + faker.name().lastName();
            String username = firstName + "." + lastName + faker.number().digits(5);


            Utente newUtente = new Utente(email, nomeCompleto, username);
            utenteService.saveUtente(newUtente);
            utenti.add(newUtente);
        }
        List<PostazioneAziendale> postazioni = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String nome = faker.letterify("???????????????");
            int maxOccupanti = faker.number().numberBetween(2, 20);
            TipoPostazione tipo = TipoPostazione.OPEN_SPACE;
            List<Prenotazione> prenotazioni = new ArrayList<>();
            Edificio edificio = edifici.get(faker.number().numberBetween(0, edifici.size()));

            PostazioneAziendale newPostazione = new PostazioneAziendale(
                    UUID.randomUUID(), nome, edificio, maxOccupanti, prenotazioni, tipo);

            postazioneService.savePostazione(newPostazione);
            postazioni.add(newPostazione);
        }


        for (PostazioneAziendale postazione : postazioni) {
            int numeroPrenotazioni = faker.number().numberBetween(0, 10);
            List<Prenotazione> prenotazioniPostazione = new ArrayList<>();

            for (int i = 0; i < numeroPrenotazioni; i++) {
                Utente utenteRandom = utenti.get(faker.number().numberBetween(0, utenti.size()));

                LocalDate inizio = LocalDate.now().minusYears(1);
                LocalDate fine = LocalDate.now().plusYears(1);
                Date startDate = Date.from(inizio.atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date endDate = Date.from(fine.atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date dataPrenotazioneDate = faker.date().between(startDate, endDate);
                LocalDate dataPrenotazione = dataPrenotazioneDate.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();
                try {
                    Prenotazione prenotazione = prenotazioneService.creaPrenotazione(
                            utenteRandom.getId(),
                            postazione.getId(),
                            dataPrenotazione
                    );
                    prenotazioniPostazione.add(prenotazione);
                } catch (ValidationException e) {
                    System.out.println("Prenotazione NON valida: " + e.getMessage());
                }


                postazione.setPrenotazioni(prenotazioniPostazione);
                postazioneService.savePostazione(postazione);
            }
        }*/

        List<Edificio> edifici = edificioService.findAll();
        List<PostazioneAziendale> listaPostazioni = postazioneService.ricercaPerTipoEPerCitta(TipoPostazione.OPEN_SPACE, "Quarto Giacinto a mare");
        System.out.println("Postazioni trovate per tipo e città: " + listaPostazioni.size());
        listaPostazioni.forEach(postazioneAziendale -> System.out.println("- La postazione con id : " + postazioneAziendale.getId() + " ed il nome dell'edificio è : " + postazioneAziendale.getEdificio().getNome()));
    }
}
