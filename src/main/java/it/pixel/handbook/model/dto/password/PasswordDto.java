package it.pixel.handbook.model.dto.password;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class PasswordDto {

    private UUID id;
    private String email;
    private String username;
    private String password;
    private String descrizione;

}
