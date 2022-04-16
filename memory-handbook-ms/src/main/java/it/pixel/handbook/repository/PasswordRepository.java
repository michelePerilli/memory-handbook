package it.pixel.handbook.repository;

import it.pixel.handbook.model.dto.password.PasswordDto;
import it.pixel.handbook.model.entity.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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
     * @return the page
     */
    @Query("SELECT new it.pixel.handbook.model.dto.password.PasswordDto(PW.id, PW.email, PW.username, PW.password, PW.descrizione) " +
            "FROM Password PW " +
            "WHERE PW.flagEliminato = '0' " +
            "AND :email IS NULL OR LOWER(PW.email) LIKE %:email% " +
            "AND :username IS NULL OR LOWER(PW.username) LIKE %:username% " +
            "AND :password IS NULL OR LOWER(PW.password) LIKE %:password% " +
            "AND :descrizione IS NULL OR LOWER(PW.descrizione) LIKE %:descrizione% " +
            " ")
    List<PasswordDto> ricercaPassword(String email, String username, String password, String descrizione);

}
