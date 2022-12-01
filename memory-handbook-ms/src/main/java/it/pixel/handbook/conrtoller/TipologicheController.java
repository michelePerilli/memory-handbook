package it.pixel.handbook.conrtoller;

import it.pixel.handbook.model.dto.TipologicaDto;
import it.pixel.handbook.service.TipologicheService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Project: memory-handbook
 * Author: Michele
 * File: TipologicheController
 * Creation: 01/07/2022
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class TipologicheController {

    private final TipologicheService tipologicheService;

    public TipologicheController(TipologicheService tipologicheService) {
        this.tipologicheService = tipologicheService;
    }

    @GetMapping("/categorie")
    public ResponseEntity<List<TipologicaDto>> getCategorie() {
        return tipologicheService.findAllCategorie();
    }
}
