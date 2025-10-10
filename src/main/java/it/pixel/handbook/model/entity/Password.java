package it.pixel.handbook.model.entity;

import it.pixel.handbook.component.filter.annotation.OnlyNotDeleted;
import it.pixel.handbook.model.entity.embedded.Audit;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;


@Getter
@Setter
@Entity
@OnlyNotDeleted
@Table(name = "passwords", schema = "handbook")
public class Password extends Audit {
    @Id
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "flag_eliminato")
    private Boolean flagEliminato = false;


}
