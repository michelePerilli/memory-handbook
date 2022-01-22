package handbook.repository;

import handbook.model.dto.password.PasswordDto;
import handbook.model.entity.Password;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * The interface Password repository.
 */
@Repository
public interface PasswordRepository extends JpaRepository<Password, Long> {

    /**
     * Ricerca password page.
     *
     * @param email         the email
     * @param username      the username
     * @param password      the password
     * @param descrizione   the descrizione
     * @param flagEliminato the flag eliminato
     * @param pageable      the pageable
     * @return the page
     */
    @Query("SELECT new handbook.model.dto.password.PasswordDto(PW.sequId, PW.email, PW.username, PW.password, PW.descrizione) " +
            "FROM Password PW " +
            "WHERE PW.flagEliminato = :flagEliminato " +
            "AND :email IS NULL OR PW.email LIKE %:email% " +
            "AND :username IS NULL OR PW.username LIKE %:username% " +
            "AND :password IS NULL OR PW.password LIKE %:password% " +
            "AND :descrizione IS NULL OR PW.descrizione LIKE %:descrizione% " +
            " ")
    Page<PasswordDto> ricercaPassword(String email, String username, String password, String descrizione, String flagEliminato, Pageable pageable);

}
