package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Course;
import com.saraya.schoolmanagement.repositories.CourseRepository;
import com.saraya.schoolmanagement.services.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImp implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImp(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course findById(Long id) throws ResourceNotFoundException {
        Optional<Course> course = this.courseRepository.findCourseById(id);
        if (!course.isPresent())
            throw new ResourceNotFoundException("Course not available");

        return course.get();
    }

    @Override
    public Course saveCourse(Course course) {
        course.setCreatedAt(LocalDateTime.now());
        return this.courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        course.setUpdatedAt(LocalDateTime.now());
        return this.courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(Long id) throws ResourceNotFoundException {
        if (!this.courseRepository.existsCourseById(id))
            throw new ResourceNotFoundException("impossible to delete this Course");
        else
            this.courseRepository.deleteById(id);
    }

    @Override
    public List<Course> findAllCourses() {
        return this.courseRepository.findAll();
    }

    @Override
    public Page<Course> findAllCourses(Pageable pageable) {
        return this.courseRepository.findAll(pageable);
    }

    @Override
    public void deleteAllCourses() {
      this.courseRepository.deleteAll();
    }

    @Override
    public boolean isCourseExist(Course course) {
        return false;
    }
}
