package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.StudentDto;
import com.saraya.schoolmanagement.models.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto modelToDto(Student student);
    List<StudentDto> modelsToDtos(List<Student> students);

    Student dtoToModel(StudentDto studentDto);
}
