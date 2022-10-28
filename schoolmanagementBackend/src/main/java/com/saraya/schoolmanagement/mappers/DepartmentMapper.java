package com.saraya.schoolmanagement.mappers;


import com.saraya.schoolmanagement.dto.DepartmentDto;
import com.saraya.schoolmanagement.models.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto modelToDto(Department department);
    List<DepartmentDto> modelsToDtos(List<Department> departments);

    Department dtoToModel(DepartmentDto departmentDto);
}
