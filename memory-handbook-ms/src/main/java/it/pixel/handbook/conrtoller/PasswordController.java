package it.pixel.handbook.conrtoller;

import it.pixel.handbook.model.dto.password.PasswordDto;
import it.pixel.handbook.service.PasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Password controller.
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/password")
public class PasswordController {

    /**
     * The Password service.
     */
    private final PasswordService passwordService;

    /**
     * Instantiates a new Password controller.
     *
     * @param passwordService the password service
     */
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    /**
     * Ricerca password response entity.
     *
     * @param formRicerca the form ricerca
     * @return the response entity
     */
    @PostMapping(value = "/ricerca")
    public ResponseEntity<List<PasswordDto>> ricercaPassword(@RequestBody PasswordDto formRicerca) {
        return passwordService.ricercaPassword(formRicerca);
    }

    /**
     * Inserisci segnalazione penale response entity.
     *
     * @param dettaglioRequest the dettaglio request
     * @return the response entity
     */
    @PutMapping(value = "/inserimento")
    public ResponseEntity<Long> inserisciPassword(@RequestBody PasswordDto dettaglioRequest) {
        return passwordService.inserisciPassword(dettaglioRequest);
    }


    /**
     * Lista password response entity.
     *
     * @return the response entity
     */
    @GetMapping(value = "/list")
    public ResponseEntity<List<PasswordDto>> listaPassword() {
        return passwordService.listaPassword();
    }

}
