package danieleSanzari.u5w1d5project.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
@Getter
@Setter
@NoArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    @Column(name = "data_prenotazione")
    private LocalDate data;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private PostazioneAziendale postazioneAziendale;

    public Prenotazione(LocalDate data, PostazioneAziendale postazioneAziendale, Utente utente) {
        this.data = data;
        this.postazioneAziendale = postazioneAziendale;
        this.utente = utente;
    }
}
