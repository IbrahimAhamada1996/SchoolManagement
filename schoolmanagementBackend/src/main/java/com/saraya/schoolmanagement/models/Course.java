package com.saraya.schoolmanagement.models;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private Float totalHour;
    private Float teachHour;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee teacher;
    @ManyToMany(targetEntity = Student.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "COURSE_ID", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id")}
    )
    private Set<Student> students;
    @ManyToOne(fetch = FetchType.LAZY)
    private Classroom classroom;
    @ManyToOne(fetch = FetchType.LAZY)
    private Module module;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(Float totalHour) {
        this.totalHour = totalHour;
    }

    public Float getTeachHour() {
        return teachHour;
    }

    public void setTeachHour(Float teachHour) {
        this.teachHour = teachHour;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Employee getTeacher() {
        return teacher;
    }

    public void setTeacher(Employee teacher) {
        this.teacher = teacher;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
