package gianni_bussoletti.beu2s3exam.entites;

import gianni_bussoletti.beu2s3exam.enums.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "clienti")
@ToString
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false, unique = true)
    private String mail;
    @Column(nullable = false)
    private String password;
    @Column(name = "avatar_url", nullable = false)
    private String avatarURL;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    @Column(nullable = false)
    private Role role;
    public Cliente(String name, String surname, String mail, String password, String avatarURL, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
        this.avatarURL = avatarURL;
        this.birthDate = birthDate;
        this.role = Role.CLIENTE;
    }
}
