package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.InscriptionDto;
import com.saraya.schoolmanagement.models.Inscription;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InscriptionMapper {

    InscriptionMapper INSTANCE = Mappers.getMapper(InscriptionMapper.class);

    InscriptionDto modelToDto(Inscription inscription);
    List<InscriptionDto> modelsToDtos(List<Inscription> inscriptions);

    Inscription dtoToModel(InscriptionDto inscriptionDto);
}
