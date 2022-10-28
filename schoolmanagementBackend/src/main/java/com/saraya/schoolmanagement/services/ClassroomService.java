package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Classroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClassroomService {

    Classroom findById(Long id) throws ResourceNotFoundException;

    Classroom saveClassroom(Classroom classroom);

    Classroom updateClassroom(Classroom classroom);

    void deleteClassroomById(Long id) throws  ResourceNotFoundException;

    List<Classroom> findAllClassrooms();
    Page<Classroom> findAllClassrooms(Pageable pageable);

    void deleteAllClassrooms();

    boolean isClassroomExist(Classroom classroom);
}
