package com.saraya.schoolmanagement.controllers;

import com.saraya.schoolmanagement.dto.StudentDto;
import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.mappers.StudentMapper;
import com.saraya.schoolmanagement.models.Student;
import com.saraya.schoolmanagement.services.StudentService;
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
@RequestMapping(value = "/students")
public class StudentController {

    private final StudentService studentService;

    private final StudentMapper studentMapper;

    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @PostMapping
    public ResponseEntity<?>
    createStudent(@RequestBody StudentDto studentDto){
        Student student =  studentService.saveStudent(studentMapper.dtoToModel(studentDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(studentMapper.modelToDto(student));
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> findAll(){
      List<Student> students =  studentService.findAllStudents();
      if (students.isEmpty()){
          return new ResponseEntity<List<StudentDto>>(HttpStatus.NO_CONTENT);
      }
       return new ResponseEntity<List<StudentDto>>( studentMapper.modelsToDtos(students), HttpStatus.OK);
    }

   /* @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        List<Student> students = new ArrayList<Student>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> studentPage = studentService.findAllStudents(pageable);
        students = studentPage.getContent();
        Map<String,Object> response = new HashMap<>();
        response.put("students",studentMapper.modelsToDtos(students));
        response.put("currentPage",studentPage.getNumber());
        response.put("totalItems",studentPage.getTotalElements());
        response.put("totalPages",studentPage.getTotalPages());
        if (students.isEmpty()){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Map<String,Object>>(response , HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> findStudentById(@PathVariable Long id) throws ResourceNotFoundException {
        StudentDto studentDto = studentMapper.modelToDto(studentService.findById(id));
        if (studentDto == null || id ==null) {
            return new ResponseEntity<StudentDto>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@RequestBody StudentDto studentDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id ==null) {
            return new ResponseEntity<StudentDto>(HttpStatus.NO_CONTENT);
        }
        Student student =  this.studentService.updateStudent(this.studentMapper.dtoToModel(studentDto));
        return new ResponseEntity<StudentDto>(this.studentMapper.modelToDto(student), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id == null) {
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        }
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
}
