package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Faculty;
import com.saraya.schoolmanagement.repositories.FacultyRepository;
import com.saraya.schoolmanagement.services.FacultyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImp implements FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyServiceImp(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty findById(Long id) throws ResourceNotFoundException {
        Optional<Faculty> faculty = this.facultyRepository.findFacultyById(id);
        if(!faculty.isPresent())
            throw new ResourceNotFoundException("Faculty not available");
        return faculty.get();
    }

    @Override
    public Faculty saveFaculty(Faculty faculty) {
        return this.facultyRepository.save(faculty);
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        return this.facultyRepository.save(faculty);
    }

    @Override
    public void deleteFacultyById(Long id) throws ResourceNotFoundException {
        if (!this.facultyRepository.existsFacultyById(id))
            throw new ResourceNotFoundException("impossible to delete this Faculty");
        else
            this.facultyRepository.deleteById(id);
    }

    @Override
    public List<Faculty> findAllFacultys() {
        return this.facultyRepository.findAll();
    }

    @Override
    public Page<Faculty> findAllFacultys(Pageable pageable) {
        return this.facultyRepository.findAll(pageable);
    }

    @Override
    public void deleteAllFacultys() {
        this.facultyRepository.deleteAll();
    }

    @Override
    public boolean isFacultyExist(Faculty faculty) {
        return false;
    }
}
