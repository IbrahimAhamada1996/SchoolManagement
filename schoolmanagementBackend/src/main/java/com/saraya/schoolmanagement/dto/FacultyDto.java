package com.saraya.schoolmanagement.dto;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.io.Serializable;
public class FacultyDto implements Serializable{
    
    private Long id;
    private String name;
    @OneToMany
    private List<InscriptionDto> inscriptions;
    @ManyToMany
    private List<ModuleDto> modules;
    @ManyToMany
    private List<GradeDto> grades;
    @ManyToOne
    private DepartmentDto department;

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

    public List<InscriptionDto> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<InscriptionDto> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public List<ModuleDto> getModules() {
        return modules;
    }

    public void setModules(List<ModuleDto> modules) {
        this.modules = modules;
    }

    public List<GradeDto> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeDto> grades) {
        this.grades = grades;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }
}
