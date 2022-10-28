package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.SchoolCareer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SchoolCareerService {
    SchoolCareer findById(Long id) throws ResourceNotFoundException;

    SchoolCareer saveSchoolCareer(SchoolCareer schoolCareer);

    SchoolCareer updateSchoolCareer(SchoolCareer schoolCareer);

    void deleteSchoolCareerById(Long id) throws  ResourceNotFoundException;

    List<SchoolCareer> findAllSchoolCareers();
    Page<SchoolCareer> findAllSchoolCareers(Pageable pageable);

    void deleteAllSchoolCareers();

    boolean isSchoolCareerExist(SchoolCareer schoolCareer);
}
