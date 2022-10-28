package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.FacultyDto;
import com.saraya.schoolmanagement.models.Faculty;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FacultyMapper {

    FacultyMapper INSTANCE = Mappers.getMapper(FacultyMapper.class);

    FacultyDto modelToDto(Faculty faculty);
    List<FacultyDto> modelsToDtos(List<Faculty> faculties);

    Faculty dtoToModel(FacultyDto facultyDto);
}
