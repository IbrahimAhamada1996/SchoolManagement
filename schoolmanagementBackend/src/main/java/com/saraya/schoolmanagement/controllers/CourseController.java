package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.CourseDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.CourseMapper;
import com.saraya.schoolmanagement.models.Course;
import com.saraya.schoolmanagement.services.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    private final CourseService courseService;

    private final CourseMapper courseMapper;

    public CourseController(CourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }


    @PostMapping
    public ResponseEntity<?>
    createCourse(@RequestBody CourseDto courseDto){
        Course course =  courseService.saveCourse(courseMapper.dtoToModel(courseDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(courseMapper.modelToDto(course));
    }
    
    @GetMapping
    public ResponseEntity<List<CourseDto>> findAll(){
      List<Course> courses =  courseService.findAllCourses();
      if (courses.isEmpty()){
          return new ResponseEntity<List<CourseDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<CourseDto>>( courseMapper.modelsToDtos(courses), HttpStatus.OK);
    }

  /*  @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Course> courses = new ArrayList<Course>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Course> coursePage = courseService.findAllCourses(pageable);
        courses = coursePage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("courses",courseMapper.modelsToDtos(courses));
        response.put("currentPage",coursePage.getNumber());
        response.put("totalItems",coursePage.getTotalElements());
        response.put("totalPages",coursePage.getTotalPages());
        if (courses.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> findCourseById(@PathVariable Long id) throws ResourceNotFoundException {
        CourseDto courseDto = courseMapper.modelToDto(courseService.findById(id));
        if (courseDto == null || id ==null) {
            return new ResponseEntity<CourseDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<CourseDto>(courseDto, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> updateCourseById(@RequestBody CourseDto courseDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<CourseDto>(HttpStatus.NO_CONTENT);
        }
        Course course =  this.courseService.updateCourse(this.courseMapper.dtoToModel(courseDto));
        return new ResponseEntity<CourseDto>(this.courseMapper.modelToDto(course), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourseById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        courseService.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }
}
