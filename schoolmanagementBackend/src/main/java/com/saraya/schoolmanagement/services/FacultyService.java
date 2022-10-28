package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Faculty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FacultyService {
    Faculty findById(Long id) throws ResourceNotFoundException;

    Faculty saveFaculty(Faculty faculty);

    Faculty updateFaculty(Faculty faculty);

    void deleteFacultyById(Long id) throws ResourceNotFoundException;

    List<Faculty> findAllFacultys();
    Page<Faculty> findAllFacultys(Pageable pageable);

    void deleteAllFacultys();

    boolean isFacultyExist(Faculty faculty);
}
