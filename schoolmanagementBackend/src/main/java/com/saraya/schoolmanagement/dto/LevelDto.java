package com.saraya.schoolmanagement.dto;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.io.Serializable;
public class LevelDto implements Serializable{

    private Long id;
    private String name;
    private int semester;
    @ManyToOne
    private GradeDto grade;
    @OneToMany
    private List<ModuleDto> modules;

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

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public GradeDto getGrade() {
        return grade;
    }

    public void setGrade(GradeDto grade) {
        this.grade = grade;
    }

    public List<ModuleDto> getModules() {
        return modules;
    }

    public void setModules(List<ModuleDto> modules) {
        this.modules = modules;
    }
}
