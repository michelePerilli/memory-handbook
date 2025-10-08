package it.pixel.handbook.repository;

import it.pixel.handbook.model.dto.password.PasswordDto;
import it.pixel.handbook.model.entity.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PasswordRepository extends JpaRepository<Password, Long> {


    @Query("from Password pw " +
            "where false = false " +
            "and :#{#filter.email} is null or lower(pw.email) like concat('%',lower(:#{#filter.email}),'%') " +
            "and :#{#filter.username} is null or lower(pw.username) like concat('%',lower(:#{#filter.username}),'%') " +
            "and :#{#filter.password} is null or lower(pw.password) like concat('%',lower(:#{#filter.password}),'%') " +
            "and :#{#filter.descrizione} is null or lower(pw.descrizione) like concat('%',lower(:#{#filter.descrizione}),'%') " +
            " ")
    List<PasswordDto> ricercaPassword(PasswordDto filter);

}
