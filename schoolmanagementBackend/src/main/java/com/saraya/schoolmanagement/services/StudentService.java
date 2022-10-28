package com.saraya.schoolmanagement.services;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    Student findById(Long id) throws ResourceNotFoundException;

    Student saveStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudentById(Long id) throws  ResourceNotFoundException;

    List<Student> findAllStudents();
    Page<Student> findAllStudents(Pageable pageable);

    void deleteAllStudents();

    boolean isStudentExist(Student student);
}
