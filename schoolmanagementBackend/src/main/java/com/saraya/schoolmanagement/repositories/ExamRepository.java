package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamRepository extends CrudRepository<Exam,Long> {
    Optional<Exam> findExamById(Long id);
    List<Exam> findAll();
    Page<Exam> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsExamById(Long id);
}
