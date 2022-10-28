package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository  extends CrudRepository<Employee,Long> {
    Optional<Employee> findEmployeeById(Long id);
    List<Employee> findAll();
    Page<Employee> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsEmployeeById(Long id);
}
