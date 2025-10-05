package it.pixel.handbook.model.dto.password;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * The type Password dto.
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class PasswordDto {

    /**
     * The Sequ id.
     */
    private Long id;
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
