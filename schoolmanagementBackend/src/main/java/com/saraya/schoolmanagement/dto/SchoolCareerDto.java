package com.saraya.schoolmanagement.dto;

import javax.persistence.ManyToMany;
import java.util.List;
import java.io.Serializable;
public class SchoolCareerDto implements Serializable {

    private Long id;
    private String year;
    private String level;
    private String faculty;
    private String school;
    private String results;
    private String createdAt;
    private  String updatedAt;
    @ManyToMany
    private List<StudentDto> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }
}
