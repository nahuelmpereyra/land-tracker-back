package com.api.landtracker.model.mappers;

import com.api.landtracker.model.dto.LoteDTO;
import com.api.landtracker.model.entities.Lote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoteMapper {


    LoteDTO loteToLoteDTO(Lote lote);

    List<LoteDTO> lotesToLotesDTO(List<Lote> lotes);

    @Mapping(target = "posicionLote.x", source = "posicionLote.x")
    @Mapping(target = "posicionLote.y", source = "posicionLote.y")
    @Mapping(target = "posicionLote.z", source = "posicionLote.z")
    Lote loteDTOToLote(LoteDTO loteDTO);

    List<Lote> lotesDTOToLotes(List<LoteDTO> lotesDTO);

}
