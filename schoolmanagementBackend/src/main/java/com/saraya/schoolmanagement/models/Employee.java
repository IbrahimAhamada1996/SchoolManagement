package com.saraya.schoolmanagement.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue("employee")
public class Employee extends User{
    private Float salary;
    private LocalDate hireDate;
    private String situationFamilliale;
    private boolean decede = false;
    private boolean fire= false;
    private int childNumber;
    @ManyToMany(targetEntity = Schedule.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "TEACHER_ID", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "SCHEDULE_ID", referencedColumnName = "id")}
    )
    private Set<Schedule> schedules;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Course> courses;

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getSituationFamilliale() {
        return situationFamilliale;
    }

    public void setSituationFamilliale(String situationFamilliale) {
        this.situationFamilliale = situationFamilliale;
    }

    public boolean isDecede() {
        return decede;
    }

    public void setDecede(boolean decede) {
        this.decede = decede;
    }

    public boolean isFire() {
        return fire;
    }

    public void setFire(boolean fire) {
        this.fire = fire;
    }

    public int getChildNumber() {
        return childNumber;
    }

    public void setChildNumber(int childNumber) {
        this.childNumber = childNumber;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }


}
