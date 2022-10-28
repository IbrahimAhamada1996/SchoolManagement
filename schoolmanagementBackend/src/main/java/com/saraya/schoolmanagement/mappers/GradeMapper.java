package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.GradeDto;
import com.saraya.schoolmanagement.models.Grade;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GradeMapper {

    GradeMapper INSTANCE = Mappers.getMapper(GradeMapper.class);

    GradeDto modelToDto(Grade grade);
    List<GradeDto> modelsToDtos(List<Grade> grades);

    Grade dtoToModel(GradeDto gradeDto);
}
