package handbook.conrtoller;

import handbook.model.dto.password.PasswordDto;
import handbook.service.PasswordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Password controller.
 */
@RestController
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
     * @param pageable    the pageable
     * @return the response entity
     */
    @PostMapping(value = "/ricerca")
    public ResponseEntity<Page<PasswordDto>> ricercaPassword(@RequestBody PasswordDto formRicerca, Pageable pageable) {
        return passwordService.ricercaPassword(formRicerca, pageable);

    }

    /**
     * Inserisci segnalazione penale response entity.
     *
     * @param dettaglioRequest the dettaglio request
     * @return the response entity
     */
    @PutMapping(value = "/inserimento")
    public ResponseEntity<Long> inserisciSegnalazionePenale(@RequestBody PasswordDto dettaglioRequest) {
        return passwordService.inserisciPassword(dettaglioRequest);
    }


    /**
     * Lista password response entity.
     *
     * @param pageable the pageable
     * @return the response entity
     */
    @PostMapping(value = "/list")
    public ResponseEntity<Page<PasswordDto>> listaPassword(Pageable pageable) {
        return passwordService.listaPassword(pageable);
    }

}
