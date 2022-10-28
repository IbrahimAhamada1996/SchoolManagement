package com.saraya.schoolmanagement.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Inscription> inscriptions;
    @ManyToMany(targetEntity = Module.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "FACULTY_ID", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "MODULE_ID", referencedColumnName = "id")}
    )
    private Set<Module> modules;
    @ManyToMany(targetEntity = Grade.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "FACULTY_ID", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "MODULE_ID", referencedColumnName = "id")}
    )
    private Set<Grade> grades;
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

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

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
