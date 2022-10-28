package com.saraya.schoolmanagement.dto;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.io.Serializable;
public class ModuleDto implements Serializable{

    private Long id;
    private String name;
    private Double coeficient;
    @ManyToMany
    private List<FacultyDto> faculties;
    @OneToMany
    private List<CourseDto> courses;
    @ManyToOne
    private UnityDto unity;
    @ManyToOne
    private LevelDto level;
    @OneToMany
    private List<ExamDto> exams;

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

    public Double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(Double coeficient) {
        this.coeficient = coeficient;
    }

    public List<FacultyDto> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<FacultyDto> faculties) {
        this.faculties = faculties;
    }

    public List<CourseDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDto> courses) {
        this.courses = courses;
    }

    public UnityDto getUnity() {
        return unity;
    }

    public void setUnity(UnityDto unity) {
        this.unity = unity;
    }

    public LevelDto getLevel() {
        return level;
    }

    public void setLevel(LevelDto level) {
        this.level = level;
    }

    public List<ExamDto> getExams() {
        return exams;
    }

    public void setExams(List<ExamDto> exams) {
        this.exams = exams;
    }
}
