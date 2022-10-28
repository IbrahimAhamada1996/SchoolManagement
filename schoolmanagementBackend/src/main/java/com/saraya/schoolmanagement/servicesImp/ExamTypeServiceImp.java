package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.ExamType;
import com.saraya.schoolmanagement.repositories.ExamTypeRepository;
import com.saraya.schoolmanagement.services.ExamTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamTypeServiceImp implements ExamTypeService {
    private final ExamTypeRepository examTypeRepository;

    public ExamTypeServiceImp(ExamTypeRepository examTypeRepository) {
        this.examTypeRepository = examTypeRepository;
    }

    @Override
    public ExamType findById(Long id) throws ResourceNotFoundException {
        Optional<ExamType> examType = this.examTypeRepository.findExamTypeById(id);
        if(!examType.isPresent())
            throw new ResourceNotFoundException("ExamType not available");
        return examType.get();
    }

    @Override
    public ExamType saveExamType(ExamType examType) {
        return this.examTypeRepository.save(examType);
    }

    @Override
    public ExamType updateExamType(ExamType examType) {
        return this.examTypeRepository.save(examType);
    }

    @Override
    public void deleteExamTypeById(Long id) throws ResourceNotFoundException {
        if(!this.examTypeRepository.existsExamTypeById(id))
            throw new ResourceNotFoundException("impossible to delete this ExamType");
        else
            this.examTypeRepository.deleteById(id);
    }

    @Override
    public List<ExamType> findAllExamTypes() {
        return this.examTypeRepository.findAll();
    }

    @Override
    public Page<ExamType> findAllExamTypes(Pageable pageable) {
        return this.examTypeRepository.findAll(pageable);
    }

    @Override
    public void deleteAllExamTypes() {
        this.examTypeRepository.deleteAll();
    }

    @Override
    public boolean isExamTypeExist(ExamType examType) {
        return false;
    }
}
