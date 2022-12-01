package it.pixel.handbook.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

/**
 * Project: memory-handbook
 * Author: Michele
 * File: Categorie
 * Creation: 01/07/2022
 */
@Entity
@Setter
@Getter
public class Categorie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "codi_categoria")
    private String codiCategoria;

    @Column(name = "desc_categoria")
    private String descCategoria;

    @Column(name = "flag_eliminato")
    private Boolean flagEliminato;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie = (Categorie) o;
        return Objects.equals(id, categorie.id) && Objects.equals(codiCategoria, categorie.codiCategoria) && Objects.equals(descCategoria, categorie.descCategoria) && Objects.equals(flagEliminato, categorie.flagEliminato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codiCategoria, descCategoria, flagEliminato);
    }
}
