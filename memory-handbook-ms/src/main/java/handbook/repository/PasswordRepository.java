package handbook.repository;

import handbook.model.dto.password.RicercaPasswordResponseDto;
import handbook.model.entity.Password;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepository extends JpaRepository<Password, Long> {

    @Query("SELECT new handbook.model.dto.password.RicercaPasswordResponseDto(PW.sequId, PW.email, PW.username, PW.password, PW.descrizione) " +
            "FROM Password PW " +
            "WHERE PW.flagEliminato = :flagEliminato " +
            "AND :email IS NULL OR PW.email LIKE %:email% " +
            "AND :username IS NULL OR PW.username LIKE %:username% " +
            "AND :password IS NULL OR PW.password LIKE %:password% " +
            "AND :descrizione IS NULL OR PW.descrizione LIKE %:descrizione% " +
            " ")
    Page<RicercaPasswordResponseDto> ricercaPassword(String email, String username, String password, String descrizione, String flagEliminato, Pageable pageable);

}
