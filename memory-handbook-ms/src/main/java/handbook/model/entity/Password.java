package handbook.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "passwords")
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sequId")
    private Long sequId;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "flagEliminato")
    private String flagEliminato;

    public void setSequId(Long id) {
        this.sequId = id;
    }

    public String getFlagEliminato() {
        return flagEliminato;
    }

    public void setFlagEliminato(String flagEliminato) {
        this.flagEliminato = flagEliminato;
    }

    public Long getSequId() {
        return sequId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
