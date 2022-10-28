package com.saraya.schoolmanagement.dto;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;
import java.io.Serializable;
public class GradeDto implements Serializable{
    private Long id;
    private String name;
    @ManyToMany
    private List<FacultyDto> faculties;
    @OneToMany
    private List<LevelDto> levels;

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

    public List<FacultyDto> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<FacultyDto> faculties) {
        this.faculties = faculties;
    }

    public List<LevelDto> getLevels() {
        return levels;
    }

    public void setLevels(List<LevelDto> levels) {
        this.levels = levels;
    }
}
