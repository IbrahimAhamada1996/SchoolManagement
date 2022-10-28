package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
    Optional<Student> findStudentById(Long id);
    List<Student> findAll();
    Page<Student> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsStudentById(Long id);
//    List<Student> findStudentsByStudentNumberAndInscriptionsContains();
}
