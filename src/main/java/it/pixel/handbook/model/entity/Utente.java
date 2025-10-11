package it.pixel.handbook.model.entity;

import it.pixel.handbook.model.entity.base.Audit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "utenti", schema = "handbook")
public class Utente extends Audit {

    @Id
    @UuidGenerator
    @Column(name = "uuid", nullable = false)
    private UUID id;

    @Size(max = 255)
    @NotNull
    @Column(name = "sub", nullable = false)
    private String sub;

    @Size(max = 255)
    @Column(name = "nome")
    private String nome;

    @Size(max = 255)
    @Column(name = "cognome")
    private String cognome;

    @Size(max = 255)
    @Column(name = "email")
    private String email;

    @Size(max = 512)
    @Column(name = "url_immagine", length = 512)
    private String urlImmagine;

}