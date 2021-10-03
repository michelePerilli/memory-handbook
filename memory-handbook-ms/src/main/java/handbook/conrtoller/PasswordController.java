package handbook.conrtoller;

import handbook.model.dto.password.DettaglioPasswordDto;
import handbook.model.dto.password.RicercaPasswordRequestDto;
import handbook.model.response.GenericResponseBody;
import handbook.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/password"})
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping(value = "/ricerca")
    public ResponseEntity<GenericResponseBody> ricercaPassword(@RequestBody RicercaPasswordRequestDto formRicerca,
                                                               @RequestParam(name = "ordCol", required = false) String ordCol,
                                                               @RequestParam(name = "ordDir", required = false) String ordDir,
                                                               Pageable pageable) {
        return passwordService.ricercaPassword(formRicerca, ordCol, ordDir, pageable);
    }


    @PostMapping(value = "/inserimento")
    public ResponseEntity<GenericResponseBody> inserisciSegnalazionePenale(@RequestBody DettaglioPasswordDto dettaglioRequest) {
        return passwordService.inserisciPassword(dettaglioRequest);
    }

    @PostMapping(value = "/list")
    public ResponseEntity<GenericResponseBody> listaPassword(@RequestParam(name = "ordCol", required = false) String ordCol,
                                                             @RequestParam(name = "ordDir", required = false) String ordDir,
                                                             Pageable pageable) {
        return passwordService.listaPassword(pageable);
    }

}
