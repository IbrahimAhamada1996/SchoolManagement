package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.Faculty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty,Long> {
    Optional<Faculty> findFacultyById(Long id);
    List<Faculty> findAll();
    Page<Faculty> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsFacultyById(Long id);
}
