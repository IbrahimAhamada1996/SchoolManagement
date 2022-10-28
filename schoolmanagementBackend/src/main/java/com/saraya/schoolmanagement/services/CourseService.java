package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {
    Course findById(Long id) throws  ResourceNotFoundException;

    Course saveCourse(Course course);

    Course updateCourse(Course course);

    void deleteCourseById(Long id) throws ResourceNotFoundException;

    List<Course> findAllCourses();
    Page<Course> findAllCourses(Pageable pageable);

    void deleteAllCourses();

    boolean isCourseExist(Course course);
}
