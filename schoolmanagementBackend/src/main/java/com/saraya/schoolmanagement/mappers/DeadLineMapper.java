package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.DeadLineDto;
import com.saraya.schoolmanagement.models.DeadLine;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeadLineMapper {

    DeadLineMapper INSTANCE = Mappers.getMapper(DeadLineMapper.class);

    DeadLineDto modelToDto(DeadLine beadLine);
    List<DeadLineDto> modelsToDtos(List<DeadLine> beadLines);

    DeadLine dtoToModel(DeadLineDto beadLineDto);

}
