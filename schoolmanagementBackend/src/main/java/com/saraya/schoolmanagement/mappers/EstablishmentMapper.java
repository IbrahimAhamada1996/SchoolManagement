package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.EstablishmentDto;
import com.saraya.schoolmanagement.models.Establishment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstablishmentMapper {

    EstablishmentMapper INSTANCE = Mappers.getMapper(EstablishmentMapper.class);

    EstablishmentDto modelToDto(Establishment establishment);
    List<EstablishmentDto> modelsToDtos(List<Establishment> establishment);

    Establishment dtoToModel(EstablishmentDto establishmentDto);
}
