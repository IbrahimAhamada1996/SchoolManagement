package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Employee findById(Long id) throws ResourceNotFoundException;

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployeeById(Long id) throws  ResourceNotFoundException;

    List<Employee> findAllEmployees();

    Page<Employee> findAllEmployees(Pageable pageable);
    void deleteAllEmployees();

    boolean isEmployeeExist(Employee employee);
}
