package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.ExamType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExamTypeService {
    ExamType findById(Long id) throws ResourceNotFoundException;

    ExamType saveExamType(ExamType examType);

    ExamType updateExamType(ExamType examType);

    void deleteExamTypeById(Long id) throws  ResourceNotFoundException;

    List<ExamType> findAllExamTypes();
    Page<ExamType> findAllExamTypes(Pageable pageable);

    void deleteAllExamTypes();

    boolean isExamTypeExist(ExamType examType);
}
