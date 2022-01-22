package handbook.service;

import handbook.model.dto.password.PasswordDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

/**
 * The interface Password service.
 */
public interface PasswordService {

    /**
     * Ricerca password response entity.
     *
     * @param dto      the dto
     * @param pageable the pageable
     * @return the response entity
     */
    ResponseEntity<Page<PasswordDto>> ricercaPassword(PasswordDto dto, Pageable pageable);

    /**
     * Inserisci password response entity.
     *
     * @param dto the dto
     * @return the response entity
     */
    ResponseEntity<Long> inserisciPassword(PasswordDto dto);

    /**
     * Lista password response entity.
     *
     * @param pageable the pageable
     * @return the response entity
     */
    ResponseEntity<Page<PasswordDto>> listaPassword(Pageable pageable);
}
