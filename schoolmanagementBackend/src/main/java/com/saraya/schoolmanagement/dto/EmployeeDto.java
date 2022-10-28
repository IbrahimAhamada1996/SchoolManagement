package com.saraya.schoolmanagement.dto;


import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

public class EmployeeDto extends UserDto {
    protected Float salary;
    protected String hireDate;
    protected String situationFamilliale;
    protected boolean decede = false;
    protected boolean fire;
    protected int childNumber;

    @ManyToMany
    private List<ScheduleDto> schedules;
    @OneToMany
    private List<CourseDto> courses;

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
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
    public List<ScheduleDto> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleDto> schedules) {
        this.schedules = schedules;
    }

    public List<CourseDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDto> courses) {
        this.courses = courses;
    }

}
