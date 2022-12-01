package it.pixel.handbook.service;

import it.pixel.handbook.model.dto.password.PasswordDto;
import it.pixel.handbook.model.entity.Password;
import it.pixel.handbook.repository.PasswordRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * The type Password service.
 */
@Service
@Transactional
public class PasswordService {

    String safeToLower(String s) {
        if (s != null) return s.trim().toLowerCase();
        else return null;
    }


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
     * @param dto the dto
     * @return the response entity
     */
    public ResponseEntity<List<PasswordDto>> ricercaPassword(PasswordDto dto) {
        List<PasswordDto> fromBd = repository.ricercaPassword(
                safeToLower(dto.getEmail()),
                safeToLower(dto.getUsername()),
                safeToLower(dto.getPassword()),
                safeToLower(dto.getDescrizione()));
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

        entity = repository.save(entity);

        return ResponseEntity.ok(entity.getId());
    }


    /**
     * Lista password response entity.
     *
     * @return the response entity
     */
    public ResponseEntity<List<PasswordDto>> listaPassword() {
        List<PasswordDto> fromBd = repository.ricercaPassword(null, null, null, null);

        return ResponseEntity.ok(fromBd);
    }

}
