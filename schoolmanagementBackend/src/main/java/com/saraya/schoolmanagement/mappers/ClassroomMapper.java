package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.ClassroomDto;
import com.saraya.schoolmanagement.models.Classroom;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassroomMapper {
    ClassroomMapper INSTANCE = Mappers.getMapper(ClassroomMapper.class);

    ClassroomDto modelToDto(Classroom classroom);
    List<ClassroomDto> modelsToDtos(List<Classroom> classrooms);

    Classroom dtoToModel(ClassroomDto classroomDto);



}
