package it.demo.app.demo.mapper;

import it.demo.app.demo.model.dto.ArticoloDto;
import it.demo.app.demo.model.entitites.Articolo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticoloMapper {

    ArticoloMapper INSTANCE = Mappers.getMapper( ArticoloMapper.class );

    Articolo articoloDtoToArticolo(ArticoloDto articoloDto);

    ArticoloDto articoloToArticoloDto(Articolo articolo);

    List<ArticoloDto> listDtoTolist(List<Articolo> articoloList);

}
