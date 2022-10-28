package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.ExamType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamTypeRepository extends CrudRepository<ExamType,Long> {
    Optional<ExamType> findExamTypeById(Long id);
    List<ExamType> findAll();
    Page<ExamType> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsExamTypeById(Long id);
}
