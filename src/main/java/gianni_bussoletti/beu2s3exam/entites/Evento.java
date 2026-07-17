package gianni_bussoletti.beu2s3exam.entites;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "eventi")
public class Evento {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @Column(nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String luogo;
    @Column(nullable = false)
    private String descrizione;
    @Column(nullable = false)
    private LocalDate data;
    @Column(name = "posti_disponibili", nullable = false)
    private int postiDisponibili;
    @ManyToOne
    @JoinColumn(name = "creatore_eventi", nullable = false)
    private CreatoreEventi creatoreEventi;
    @ManyToMany
    @JoinTable(
            name = "cliente_eventi",
            joinColumns = @JoinColumn(name = "eventi_id"),
            inverseJoinColumns = @JoinColumn(name = "clenti_id")
    )
    private List<Cliente> cliente;

    public Evento(String nome, String descrizione, String luogo, LocalDate data, int postiDisponibili, CreatoreEventi creatoreEventi) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.luogo = luogo;
        this.data = data;
        this.postiDisponibili = postiDisponibili;
        this.creatoreEventi = creatoreEventi;
    }
}
