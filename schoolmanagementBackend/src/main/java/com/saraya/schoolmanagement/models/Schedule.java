package com.saraya.schoolmanagement.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToMany(targetEntity = Employee.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "SCHEDULE_ID", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "TEACHER_ID", referencedColumnName = "id")}
    )
    private Set<Employee> teachers;
    @ManyToMany(targetEntity = Student.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "SCHEDULE_ID", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id")}
    )

    private Set<Student> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Set<Employee> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Employee> teachers) {
        this.teachers = teachers;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
