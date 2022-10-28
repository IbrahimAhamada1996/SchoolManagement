package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.LevelDto;
import com.saraya.schoolmanagement.models.Level;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LevelMapper {

    LevelMapper INSTANCE = Mappers.getMapper(LevelMapper.class);

    LevelDto modelToDto(Level level);
    List<LevelDto> modelsToDtos(List<Level> levels);

    Level dtoToModel(LevelDto levelDto);
}
