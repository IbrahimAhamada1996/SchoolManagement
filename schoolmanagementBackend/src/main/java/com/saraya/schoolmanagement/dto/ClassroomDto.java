package com.saraya.schoolmanagement.dto;


import javax.persistence.OneToMany;
import java.util.List;

public class ClassroomDto extends RoomDto {
    private int ability;
    private Boolean available;
    @OneToMany
    private List<CourseDto> courses;

    public int getAbility() {
        return ability;
    }

    public void setAbility(int ability) {
        this.ability = ability;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<CourseDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDto> courses) {
        this.courses = courses;
    }
}
