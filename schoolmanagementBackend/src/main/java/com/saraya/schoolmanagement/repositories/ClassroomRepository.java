package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.Classroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassroomRepository extends CrudRepository<Classroom,Long> {

    Optional<Classroom> findClassroomById(Long id);
    List<Classroom> findAll();
    Page<Classroom> findAll(Pageable pageable);
    void deleteClassroomsById(Long id);
    boolean existsClassroomById(Long id);
}
