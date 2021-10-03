package handbook.service.impl;

import handbook.model.dto.password.DettaglioPasswordDto;
import handbook.model.dto.password.RicercaPasswordRequestDto;
import handbook.model.response.GenericResponseBody;
import handbook.model.response.PasswordResponseBody;
import handbook.model.response.RapidResponse;
import handbook.service.PasswordService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {


    @Override
    public ResponseEntity<GenericResponseBody> ricercaPassword(RicercaPasswordRequestDto dto, String ordCol, String ordDir, Pageable pageable) {
        // todo ricerca
        return RapidResponse.ok(new PasswordResponseBody());
    }

    @Override
    public ResponseEntity<GenericResponseBody> inserisciPassword(DettaglioPasswordDto dto) {
        // todo inserimento
        return RapidResponse.ok();
    }
}
