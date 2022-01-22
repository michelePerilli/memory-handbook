package handbook.model.dto.password;

public class RicercaPasswordResponseDto {

    private Long id;

    private String email;

    private String username;

    private String password;

    private String descrizione;


    public RicercaPasswordResponseDto(Long id, String email, String username, String password, String descrizione) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.descrizione = descrizione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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