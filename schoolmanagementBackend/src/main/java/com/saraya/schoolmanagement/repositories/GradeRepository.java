package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.Grade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradeRepository extends CrudRepository<Grade,Long> {
    Optional<Grade> findGradeById(Long id);
    List<Grade> findAll();
    Page<Grade> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsGradeById(Long id);
}
