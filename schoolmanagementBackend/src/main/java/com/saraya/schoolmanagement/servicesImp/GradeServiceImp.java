package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Grade;
import com.saraya.schoolmanagement.repositories.GradeRepository;
import com.saraya.schoolmanagement.services.GradeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImp implements GradeService {
    private final GradeRepository gradeRepository;

    public GradeServiceImp(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public Grade findById(Long id) throws ResourceNotFoundException {
        Optional<Grade> grade = this.gradeRepository.findGradeById(id);
        if (!grade.isPresent())
            throw new ResourceNotFoundException("Grade not available");
        return grade.get();
    }

    @Override
    public Grade saveGrade(Grade grade) {
        return this.gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(Grade grade) {
        return this.gradeRepository.save(grade);
    }

    @Override
    public void deleteGradeById(Long id) throws ResourceNotFoundException {
        if(!this.gradeRepository.existsGradeById(id))
            throw new ResourceNotFoundException("impossible to delete this grade");
        else
            this.gradeRepository.deleteById(id);
    }

    @Override
    public List<Grade> findAllGrades() {
        return this.gradeRepository.findAll();
    }

    @Override
    public Page<Grade> findAllGrades(Pageable pageable) {
        return this.gradeRepository.findAll(pageable);
    }

    @Override
    public void deleteAllGrades() {
        this.gradeRepository.deleteAll();
    }

    @Override
    public boolean isGradeExist(Grade grade) {
        return false;
    }
}
