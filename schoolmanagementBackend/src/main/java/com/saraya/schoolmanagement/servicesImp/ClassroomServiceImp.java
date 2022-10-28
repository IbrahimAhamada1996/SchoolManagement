package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Classroom;
import com.saraya.schoolmanagement.repositories.ClassroomRepository;
import com.saraya.schoolmanagement.services.ClassroomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomServiceImp implements ClassroomService {

    private final ClassroomRepository classroomRepository;

    public ClassroomServiceImp(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public Classroom findById(Long id) throws ResourceNotFoundException {
        Optional<Classroom> classroom = this.classroomRepository.findClassroomById(id);
        if(!classroom.isPresent())
            throw new ResourceNotFoundException("Classroom not available");
        return classroom.get() ;
    }

    @Override
    public Classroom saveClassroom(Classroom classroom) {

        return this.classroomRepository.save(classroom);
    }

    @Override
    public Classroom updateClassroom(Classroom classroom) {
        return this.classroomRepository.save(classroom);
    }

    @Override
    public void deleteClassroomById(Long id) throws ResourceNotFoundException {
        if (!this.classroomRepository.existsClassroomById(id))
            throw new ResourceNotFoundException("impossible to delete this classroom");
        else
            this.classroomRepository.deleteClassroomsById(id);
    }

    @Override
    public List<Classroom> findAllClassrooms() {
        return this.classroomRepository.findAll();
    }

    @Override
    public Page<Classroom> findAllClassrooms(Pageable pageable) {
        return this.classroomRepository.findAll(pageable);
    }

    @Override
    public void deleteAllClassrooms() {
        this.classroomRepository.deleteAll();
    }

    @Override
    public boolean isClassroomExist(Classroom classroom) {
        return false;
    }
}
