package it.pixel.handbook.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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


}
