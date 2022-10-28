package com.saraya.schoolmanagement.dto;

import javax.persistence.OneToMany;
import java.util.List;

public class ParentDto extends UserDto {
    private String job;
    @OneToMany
    private List<StudentDto> students;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }
}
