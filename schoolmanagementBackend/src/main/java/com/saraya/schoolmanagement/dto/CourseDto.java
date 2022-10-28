package com.saraya.schoolmanagement.dto;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;
import java.io.Serializable;

public class CourseDto implements Serializable {
    private Long id;
    private String name;
    private Float totalHour;
    private Float teachHour;
    private String createdAt;
    private  String updatedAt;
    @ManyToOne
    private EmployeeDto teacher;
    @ManyToMany
    private List<StudentDto> students;
    @ManyToOne
    private ClassroomDto classroom;
    @ManyToOne
    private ModuleDto module;

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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public EmployeeDto getTeacher() {
        return teacher;
    }

    public void setTeacher(EmployeeDto teacher) {
        this.teacher = teacher;
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }

    public ClassroomDto getClassroom() {
        return classroom;
    }

    public void setClassroom(ClassroomDto classroom) {
        this.classroom = classroom;
    }

    public ModuleDto getModule() {
        return module;
    }

    public void setModule(ModuleDto module) {
        this.module = module;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
