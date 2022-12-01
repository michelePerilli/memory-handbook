package it.pixel.handbook.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * The type Password.
 */
@Data
@Entity
@Table(name = "passwords")
public class Password {
    /**
     * The Sequ id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The Email.
     */
    @Column(name = "email")
    private String email = "";

    /**
     * The Username.
     */
    @Column(name = "username")
    private String username = "";

    /**
     * The Password.
     */
    @Column(name = "password")
    private String password = "";

    /**
     * The Descrizione.
     */
    @Column(name = "descrizione")
    private String descrizione = "";

    /**
     * The Flag eliminato.
     */
    @Column(name = "flag_eliminato")
    private Boolean flagEliminato = false;


}
