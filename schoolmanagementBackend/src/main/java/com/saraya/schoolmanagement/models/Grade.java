package com.saraya.schoolmanagement.models;

import javax.persistence.*;
import java.util.Set;
import java.util.Set;

@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @ManyToMany(targetEntity = Faculty.class,fetch = FetchType.EAGER,cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "MODULE_ID", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "FACULTY_ID", referencedColumnName = "id")}
    )
    private Set<Faculty> faculties;
    @OneToMany(fetch = FetchType.EAGER,cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private Set<Level> levels;

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

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }

    public Set<Level> getLevels() {
        return levels;
    }

    public void setLevels(Set<Level> levels) {
        this.levels = levels;
    }
}
