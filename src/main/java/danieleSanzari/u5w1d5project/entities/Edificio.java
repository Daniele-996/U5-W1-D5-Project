package danieleSanzari.u5w1d5project.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "edifici")
@Getter
@Setter
@NoArgsConstructor
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String nome;
    private String indirizzo;
    private String citta;
    @OneToMany(mappedBy = "edificio")
    private List<PostazioneAziendale> postazioniAziendali;

    public Edificio(String citta, String indirizzo, String nome) {
        this.citta = citta;
        this.indirizzo = indirizzo;
        this.nome = nome;
    }
}
