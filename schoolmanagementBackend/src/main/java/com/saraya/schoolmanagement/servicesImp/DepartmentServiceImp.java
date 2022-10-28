package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Department;
import com.saraya.schoolmanagement.repositories.DepartmentRepository;
import com.saraya.schoolmanagement.services.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImp(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department findById(Long id) throws ResourceNotFoundException {
        Optional<Department> department = this.departmentRepository.findDepartmentById(id);
        if(!department.isPresent())
            throw new ResourceNotFoundException("Department not available");

        return department.get();
    }

    @Override
    public Department saveDepartment(Department department) {
        return this.departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department) {
        return this.departmentRepository.save(department);
    }

    @Override
    public void deleteDepartmentById(Long id) throws ResourceNotFoundException {
        if(!this.departmentRepository.existsDepartmentById(id))
            throw new ResourceNotFoundException("impossible to delete Department");
        else
            this.departmentRepository.deleteById(id);
    }

    @Override
    public List<Department> findAllDepartments() {
        return this.departmentRepository.findAll();
    }

    @Override
    public Page<Department> findAllDepartments(Pageable pageable) {
        return this.departmentRepository.findAll(pageable);
    }

    @Override
    public void deleteAllDepartments() {
        this.departmentRepository.deleteAll();
    }

    @Override
    public boolean isDepartmentExist(Department Department) {
        return false;
    }
}
