package it.demo.app.demo.mapper;

import it.demo.app.demo.model.dto.UtenteDto;
import it.demo.app.demo.model.entitites.Utente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UtenteMapper {

    UtenteMapper INSTANCE = Mappers.getMapper( UtenteMapper.class );

    Utente utenteDtoToUtente(UtenteDto utenteDto);
}
