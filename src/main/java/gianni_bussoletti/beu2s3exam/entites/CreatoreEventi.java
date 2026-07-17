package gianni_bussoletti.beu2s3exam.entites;

import gianni_bussoletti.beu2s3exam.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Setter;

import java.util.UUID;

@Entity
public class CreatoreEventi {

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
    @Column(nullable = false)
    private Role role;

    public CreatoreEventi(String name, String surname, String mail, String password) {
        this.role = Role.CREATORE_EVENTI;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
    }
}
