package handbook.service;

import handbook.model.dto.password.PasswordDto;
import handbook.model.entity.Password;
import handbook.repository.PasswordRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/**
 * The type Password service.
 */
@Service
public class PasswordService {

    /**
     * The constant FALSE.
     */
    private final static String FALSE = "0";

    /**
     * The Repository.
     */
    private final PasswordRepository repository;

    /**
     * Instantiates a new Password service.
     *
     * @param repository the repository
     */
    public PasswordService(PasswordRepository repository) {
        this.repository = repository;
    }


    /**
     * Ricerca password response entity.
     *
     * @param dto      the dto
     * @param pageable the pageable
     * @return the response entity
     */
    public ResponseEntity<Page<PasswordDto>> ricercaPassword(PasswordDto dto, Pageable pageable) {
        Page<PasswordDto> fromBd = repository.ricercaPassword(dto.getEmail(), dto.getUsername(), dto.getPassword(), dto.getDescrizione(), FALSE, pageable);

        return ResponseEntity.ok(fromBd);
    }


    /**
     * Inserisci password response entity.
     *
     * @param dto the dto
     * @return the response entity
     */
    public ResponseEntity<Long> inserisciPassword(PasswordDto dto) {

        Password entity = new Password();
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setDescrizione(dto.getDescrizione());
        entity.setUsername(dto.getUsername());
        entity.setFlagEliminato(FALSE);

        repository.save(entity);

        return ResponseEntity.ok(entity.getSequId());
    }


    /**
     * Lista password response entity.
     *
     * @param pageable the pageable
     * @return the response entity
     */
    public ResponseEntity<Page<PasswordDto>> listaPassword(Pageable pageable) {
        Page<PasswordDto> fromBd = repository.ricercaPassword(null, null, null, null, FALSE, pageable);

        return ResponseEntity.ok(fromBd);
    }

}
