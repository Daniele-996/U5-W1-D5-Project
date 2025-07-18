package danieleSanzari.u5w1d5project.entities;

import danieleSanzari.u5w1d5project.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "postazioni_aziendali")
@Getter
@Setter
@NoArgsConstructor
public class PostazioneAziendale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private UUID codice;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;
    @Column(name = "numero_max_partecipanti")
    private int numeroMaxPartecipanti;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
    @OneToMany(mappedBy = "postazioneAziendale")
    private List<Prenotazione> prenotazioni;

    public PostazioneAziendale(UUID codice, String descrizione, Edificio edificio, int numeroMaxPartecipanti, List<Prenotazione> prenotazioni, TipoPostazione tipo) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.edificio = edificio;
        this.numeroMaxPartecipanti = numeroMaxPartecipanti;
        this.prenotazioni = prenotazioni;
        this.tipo = tipo;
    }
}
