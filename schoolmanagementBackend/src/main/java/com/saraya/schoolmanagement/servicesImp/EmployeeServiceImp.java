package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Employee;
import com.saraya.schoolmanagement.repositories.EmployeeRepository;
import com.saraya.schoolmanagement.repositories.RoleRepository;
import com.saraya.schoolmanagement.services.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository, RoleRepository roleRepository) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Employee findById(Long id) throws ResourceNotFoundException {
        Optional<Employee> employee = this.employeeRepository.findEmployeeById(id);
        if (!employee.isPresent())
            throw new ResourceNotFoundException("Employee not available");
        return employee.get();
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        employee.setCreatedAt(LocalDateTime.now());
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        employee.setUpdatedAt(LocalDateTime.now());
        return this.employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) throws ResourceNotFoundException {
        if (!this.employeeRepository.existsEmployeeById(id))
            throw new ResourceNotFoundException("Impossible to delete this Employee");
        else
            this.employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAllEmployees(Pageable pageable) {
        return this.employeeRepository.findAll(pageable);
    }

    @Override
    public void deleteAllEmployees() {
        this.employeeRepository.deleteAll();
    }

    @Override
    public boolean isEmployeeExist(Employee employee) {
        return false;
    }
}
