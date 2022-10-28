package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Grade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GradeService {
    Grade findById(Long id) throws ResourceNotFoundException;

    Grade saveGrade(Grade grade);

    Grade updateGrade(Grade grade);

    void deleteGradeById(Long id) throws  ResourceNotFoundException;

    List<Grade> findAllGrades();
    Page<Grade> findAllGrades(Pageable pageable);

    void deleteAllGrades();

    boolean isGradeExist(Grade grade);
}
