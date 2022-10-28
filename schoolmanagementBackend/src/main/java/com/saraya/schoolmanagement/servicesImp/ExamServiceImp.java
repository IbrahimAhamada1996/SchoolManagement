package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Exam;
import com.saraya.schoolmanagement.repositories.ExamRepository;
import com.saraya.schoolmanagement.services.ExamService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImp implements ExamService {
    private final ExamRepository examRepository;

    public ExamServiceImp(ExamRepository examRepository) {
        this.examRepository = examRepository;

    }

    @Override
    public Exam findById(Long id) throws ResourceNotFoundException {
        Optional<Exam> exam = this.examRepository.findExamById(id);
        if (!exam.isPresent())
            throw new ResourceNotFoundException("Exam not available");
        return exam.get();
    }

    @Override
    public Exam saveExam(Exam exam) {
        exam.setCreatedAt(LocalDateTime.now());
        return this.examRepository.save(exam);
    }

    @Override
    public Exam updateExam(Exam exam) {
        exam.setUpdatedAt(LocalDateTime.now());
        return this.examRepository.save(exam);
    }

    @Override
    public void deleteExamById(Long id) throws ResourceNotFoundException {
        if (this.examRepository.existsExamById(id))
            throw new ResourceNotFoundException("Impossible to delete Exam");
        else
            this.examRepository.deleteById(id);
    }

    @Override
    public List<Exam> findAllExams() {
        return this.examRepository.findAll();
    }

    @Override
    public Page<Exam> findAllExams(Pageable pageable) {
        return this.examRepository.findAll(pageable);
    }

    @Override
    public void deleteAllExams() {
        this.examRepository.deleteAll();
    }

    @Override
    public boolean isExamExist(Exam exam) {
        return false;
    }
}
