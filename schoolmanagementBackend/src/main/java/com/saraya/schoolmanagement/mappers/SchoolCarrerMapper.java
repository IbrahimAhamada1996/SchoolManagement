package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.SchoolCareerDto;
import com.saraya.schoolmanagement.models.SchoolCareer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SchoolCarrerMapper {
    SchoolCarrerMapper INSTANCE = Mappers.getMapper(SchoolCarrerMapper.class);
    SchoolCareerDto modelToDto(SchoolCareer schoolCareer);
    List<SchoolCareerDto> modelsToDtos(List<SchoolCareer> schoolCareer);

    SchoolCareer dtoToModel(SchoolCareerDto schoolCareerDto);
}
