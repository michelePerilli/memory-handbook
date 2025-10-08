package it.pixel.handbook.component.mapper;

import it.pixel.handbook.model.dto.password.PasswordDto;
import it.pixel.handbook.model.entity.Password;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HandbookMapper {

    Password toEntity(PasswordDto dto);

    PasswordDto toDto(Password entity);
}
