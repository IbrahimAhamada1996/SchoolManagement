package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.SchoolCareer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SchoolCareerRepository extends CrudRepository<SchoolCareer,Long> {
    Optional<SchoolCareer> findSchoolCareerById(Long id);
    List<SchoolCareer> findAll();
    Page<SchoolCareer> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsSchoolCareerById(Long id);
}
