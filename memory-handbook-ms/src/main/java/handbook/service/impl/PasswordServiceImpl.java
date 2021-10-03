package handbook.service.impl;

import handbook.model.dto.password.DettaglioPasswordDto;
import handbook.model.dto.password.RicercaPasswordRequestDto;
import handbook.model.dto.password.RicercaPasswordResponseDto;
import handbook.model.entity.Password;
import handbook.model.response.GenericResponseBody;
import handbook.model.response.PasswordResponseBody;
import handbook.model.response.RapidResponse;
import handbook.repository.PasswordRepository;
import handbook.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {

    private final static String FALSE = "0";

    @Autowired
    PasswordRepository repository;

    @Override
    public ResponseEntity<GenericResponseBody> ricercaPassword(RicercaPasswordRequestDto dto, String ordCol, String ordDir, Pageable pageable) {
        Page<RicercaPasswordResponseDto> fromBd = repository.ricercaPassword(dto.getEmail(), dto.getUsername(), dto.getPassword(), dto.getDescrizione(), FALSE, pageable);

        return RapidResponse.ok(new PasswordResponseBody(fromBd));
    }

    @Override
    public ResponseEntity<GenericResponseBody> inserisciPassword(DettaglioPasswordDto dto) {

        Password entity = new Password();
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setDescrizione(dto.getDescrizione());
        entity.setUsername(dto.getUsername());
        entity.setFlagEliminato(FALSE);

        repository.save(entity);

        return RapidResponse.ok();
    }

    @Override
    public ResponseEntity<GenericResponseBody> listaPassword(Pageable pageable) {
        Page<RicercaPasswordResponseDto> fromBd = repository.ricercaPassword(null, null, null, null, FALSE, pageable);

        return RapidResponse.ok(new PasswordResponseBody(fromBd));
    }

}
