package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Long> {
    Optional<Department> findDepartmentById(Long id);
    List<Department> findAll();
    Page<Department> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsDepartmentById(Long id);
}
