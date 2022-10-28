package com.saraya.schoolmanagement.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("parent")
public class Parent extends User{
    private String job;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Student> students;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
