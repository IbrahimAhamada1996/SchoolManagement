package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.ParentDto;
import com.saraya.schoolmanagement.models.Parent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParentMapper {

    ParentMapper  INSTANCE = Mappers.getMapper(ParentMapper .class);

    ParentDto modelToDto(Parent parent);
    List<ParentDto> modelsToDtos(List<Parent> parents);

    Parent dtoToModel(ParentDto parentDto);
}
