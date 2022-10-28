package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExamService {
    Exam findById(Long id) throws ResourceNotFoundException;

    Exam saveExam(Exam exam);

    Exam updateExam(Exam exam);

    void deleteExamById(Long id) throws  ResourceNotFoundException;

    List<Exam> findAllExams();
    Page<Exam> findAllExams(Pageable pageable);

    void deleteAllExams();

    boolean isExamExist(Exam exam);
}
