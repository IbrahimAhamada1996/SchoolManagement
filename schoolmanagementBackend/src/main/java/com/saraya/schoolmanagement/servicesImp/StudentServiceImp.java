package com.saraya.schoolmanagement.servicesImp;

import com.saraya.schoolmanagement.exceptions.ResourceNotFoundException;
import com.saraya.schoolmanagement.models.Student;
import com.saraya.schoolmanagement.repositories.StudentRepository;
import com.saraya.schoolmanagement.services.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findById(Long id) throws ResourceNotFoundException {
        Optional<Student> student = this.studentRepository.findStudentById(id);
        if (!student.isPresent())
            throw new ResourceNotFoundException("Student not available");
        return student.get();
    }

    @Override
    public Student saveStudent(Student student) {
        student.setStudentNumber(studentNumber());
        student.setCreatedAt(LocalDateTime.now());
        return this.studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        student.setUpdatedAt(LocalDateTime.now());
        return this.studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) throws ResourceNotFoundException {
        if(!studentRepository.existsStudentById(id))
            throw new ResourceNotFoundException("Impossible to delete this Student");
        else
            this.studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Page<Student> findAllStudents(Pageable pageable) {
        return this.studentRepository.findAll(pageable);
    }

    @Override
    public void deleteAllStudents() {
        this.studentRepository.deleteAll();
    }

    @Override
    public boolean isStudentExist(Student student) {
        return false;
    }

    private  Long studentNumber(){
        int year = LocalDateTime.now().getYear();
        int dayOfYear = LocalDateTime.now().getDayOfYear();
        int month = LocalDateTime.now().getMonthValue();
        int hour = LocalDateTime.now().getHour();
        int minute = LocalDateTime.now().getMinute();
        return Long.valueOf(dayOfYear+year+minute+hour+month);
    }
}
