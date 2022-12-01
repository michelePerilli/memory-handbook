package it.pixel.handbook.service;

import it.pixel.handbook.model.dto.TipologicaDto;
import it.pixel.handbook.repository.CaregorieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project: memory-handbook
 * Author: Michele
 * File: TipologicheService
 * Creation: 01/07/2022
 */
@Service
public class TipologicheService {

    private final CaregorieRepository caregorieRepository;

    public TipologicheService(CaregorieRepository caregorieRepository) {
        this.caregorieRepository = caregorieRepository;
    }

    public ResponseEntity<List<TipologicaDto>> findAllCategorie() {
        return ResponseEntity.ok(caregorieRepository.findAll()
                .stream()
                .map(x -> new TipologicaDto(x.getCodiCategoria(), x.getDescCategoria()))
                .sorted()
                .toList());

    }

}
