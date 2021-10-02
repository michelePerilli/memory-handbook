package handbook.conrtoller;

import handbook.model.dto.RicercaPasswordResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = {"/password"})
public class PasswordController {

    @PostMapping(value = "/ricerca")
    public ResponseEntity<Page<RicercaPasswordResponseDto>> ricercaEsitoSegnalazione() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
