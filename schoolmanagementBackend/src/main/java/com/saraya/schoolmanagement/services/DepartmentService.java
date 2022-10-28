package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DepartmentService {
    Department findById(Long id) throws ResourceNotFoundException;

    Department saveDepartment(Department department);

    Department updateDepartment(Department department);

    void deleteDepartmentById(Long id) throws  ResourceNotFoundException;

    List<Department> findAllDepartments();
    Page<Department> findAllDepartments(Pageable pageable);

    void deleteAllDepartments();

    boolean isDepartmentExist(Department department);
}
