package it.pixel.handbook.repository;

import it.pixel.handbook.model.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Project: memory-handbook
 * Author: Michele
 * File: CaregorieRepository
 * Creation: 01/07/2022
 */
@Repository
public interface CaregorieRepository extends JpaRepository<Categorie, Long> {
}
