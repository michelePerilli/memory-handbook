package handbook.model.dto.password;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Password dto.
 */
@Data
@AllArgsConstructor
public class PasswordDto {

    /**
     * The Sequ id.
     */
    private Long sequId;
    /**
     * The Email.
     */
    private String email;
    /**
     * The Username.
     */
    private String username;
    /**
     * The Password.
     */
    private String password;
    /**
     * The Descrizione.
     */
    private String descrizione;

}
