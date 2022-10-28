package com.saraya.schoolmanagement.dto;

import javax.persistence.ManyToMany;
import java.util.List;
import java.io.Serializable;
public class ScheduleDto implements Serializable{

    private Long id;
    private String startDate;
    private String endDate;
    private String createdAt;
    private  String updatedAt;
    @ManyToMany
    private List<EmployeeDto> teachers;
    @ManyToMany
    private List<StudentDto> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<EmployeeDto> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<EmployeeDto> teachers) {
        this.teachers = teachers;
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
