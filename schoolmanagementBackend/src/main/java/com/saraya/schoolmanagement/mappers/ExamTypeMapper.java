package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.ExamTypeDto;
import com.saraya.schoolmanagement.models.ExamType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExamTypeMapper {

    ExamTypeMapper INSTANCE = Mappers.getMapper(ExamTypeMapper.class);

    ExamTypeDto modelToDto(ExamType examType);
    List<ExamTypeDto> modelsToDtos(List<ExamType> examTypes);

    ExamType dtoToModel(ExamTypeDto examTypeDto);
}
