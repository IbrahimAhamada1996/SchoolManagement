package com.saraya.schoolmanagement.mappers;

import com.saraya.schoolmanagement.dto.EmployeeDto;
import com.saraya.schoolmanagement.models.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
     EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
     EmployeeDto modelToDto(Employee employee);
     List<EmployeeDto> modelsToDtos(List<Employee> employees);

     Employee dtoToModel(EmployeeDto employeeDto);


}
