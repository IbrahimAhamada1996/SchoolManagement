package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.ExamDto;
import com.saraya.schoolmanagement.models.Exam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExamMapper {

    ExamMapper INSTANCE = Mappers.getMapper(ExamMapper.class);

    ExamDto modelToDto(Exam exam);
    List<ExamDto> modelsToDtos(List<Exam> exams);

    Exam dtoToModel(ExamDto examDto);
}
