package it.pixel.handbook.service;

import it.pixel.handbook.component.mapper.HandbookMapper;
import it.pixel.handbook.model.dto.password.PasswordDto;
import it.pixel.handbook.model.entity.Password;
import it.pixel.handbook.repository.PasswordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class PasswordService {


    private final PasswordRepository repository;
    private final HandbookMapper handbookMapper;

    public List<PasswordDto> ricercaPassword(PasswordDto dto) {
        return repository.ricercaPassword(dto);
    }

    public Long inserisciPassword(PasswordDto dto) {

        Password entity = handbookMapper.toEntity(dto);

        repository.save(entity);

        return entity.getId();
    }


    public List<PasswordDto> listaPassword() {
        return repository.findAll().stream().map(handbookMapper::toDto).toList();
    }

}
