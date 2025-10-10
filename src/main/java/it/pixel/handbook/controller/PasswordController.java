package it.pixel.handbook.controller;

import it.pixel.handbook.model.dto.password.PasswordDto;
import it.pixel.handbook.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/password", consumes = MediaType.APPLICATION_JSON_VALUE)
public class PasswordController {


    private final PasswordService passwordService;


    @PostMapping(value = "/ricerca")
    public ResponseEntity<List<PasswordDto>> ricercaPassword(@RequestBody PasswordDto formRicerca) {
        return ResponseEntity.ok(passwordService.ricercaPassword(formRicerca));
    }


    @PutMapping(value = "")
    public ResponseEntity<UUID> inserisciPassword(@RequestBody PasswordDto dettaglioRequest) {
        return ResponseEntity.ok(passwordService.inserisciPassword(dettaglioRequest));
    }


    @GetMapping(value = "/list")
    public ResponseEntity<List<PasswordDto>> listaPassword() {
        return ResponseEntity.ok(passwordService.listaPassword());
    }

}
