package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.SchoolCareer;
import com.saraya.schoolmanagement.repositories.SchoolCareerRepository;
import com.saraya.schoolmanagement.services.SchoolCareerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolCareerServiceImp implements SchoolCareerService {
    private final SchoolCareerRepository schoolCareerRepository;

    public SchoolCareerServiceImp(SchoolCareerRepository schoolCareerRepository) {
        this.schoolCareerRepository = schoolCareerRepository;
    }


    @Override
    public SchoolCareer findById(Long id) throws ResourceNotFoundException {
        Optional<SchoolCareer> schoolCareer = this.schoolCareerRepository.findSchoolCareerById(id);
        if (!schoolCareer.isPresent())
            throw new ResourceNotFoundException("SchoolCareer not available");
        return schoolCareer.get();
    }

    @Override
    public SchoolCareer saveSchoolCareer(SchoolCareer schoolCareer) {
        schoolCareer.setCreatedAt(LocalDateTime.now());
        return this.schoolCareerRepository.save(schoolCareer);
    }

    @Override
    public SchoolCareer updateSchoolCareer(SchoolCareer schoolCareer) {
        schoolCareer.setUpdatedAt(LocalDateTime.now());
        return this.schoolCareerRepository.save(schoolCareer);
    }

    @Override
    public void deleteSchoolCareerById(Long id) throws ResourceNotFoundException {
        if(!this.schoolCareerRepository.existsSchoolCareerById(id))
            throw new ResourceNotFoundException("Impossible to delete this SchoolCareer");
        else
            this.schoolCareerRepository.deleteById(id);
    }

    @Override
    public List<SchoolCareer> findAllSchoolCareers() {
        return this.schoolCareerRepository.findAll();
    }

    @Override
    public Page<SchoolCareer> findAllSchoolCareers(Pageable pageable) {
        return this.schoolCareerRepository.findAll(pageable);
    }

    @Override
    public void deleteAllSchoolCareers() {
        this.schoolCareerRepository.deleteAll();
    }

    @Override
    public boolean isSchoolCareerExist(SchoolCareer schoolCareer) {
        return false;
    }
}
