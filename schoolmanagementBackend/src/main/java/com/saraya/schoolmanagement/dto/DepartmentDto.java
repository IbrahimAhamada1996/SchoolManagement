package com.saraya.schoolmanagement.dto;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.io.Serializable;

public class DepartmentDto implements Serializable{
    private Long id;
    private String name;
    @OneToMany
    private List<FacultyDto> faculties;
    @OneToOne
    private EmployeeDto employee;

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

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }
}
