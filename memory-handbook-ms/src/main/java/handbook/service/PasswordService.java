package handbook.service;

import handbook.model.dto.password.DettaglioPasswordDto;
import handbook.model.dto.password.RicercaPasswordRequestDto;
import handbook.model.response.GenericResponseBody;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PasswordService {

    ResponseEntity<GenericResponseBody> ricercaPassword(RicercaPasswordRequestDto dto, String ordCol, String ordDir, Pageable pageable);

    ResponseEntity<GenericResponseBody> inserisciPassword(DettaglioPasswordDto dto);

}
