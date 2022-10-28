package com.saraya.schoolmanagement.repositories;

import com.saraya.schoolmanagement.models.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course,Long> {

    Optional<Course> findCourseById(Long id);
    List<Course> findAll();
    Page<Course> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsCourseById(Long id);
}
