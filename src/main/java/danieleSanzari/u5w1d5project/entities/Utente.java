package danieleSanzari.u5w1d5project.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    @Setter(AccessLevel.NONE)
    private String username;
    @Column(name = "nome_completo")
    private String nomeCompleto;
    private String email;
    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;

    public Utente(String email, String nomeCompleto, String username) {
        this.email = email;
        this.nomeCompleto = nomeCompleto;
        this.username = username;
    }
}
