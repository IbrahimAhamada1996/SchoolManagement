package com.saraya.schoolmanagement.dto;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

public class StudentDto extends UserDto {
    private Long studentNumber;
    @ManyToOne
    private ParentDto parent;
    @ManyToMany
    private List<SchoolCareerDto> schoolCareers;
    @ManyToMany
    private List<ScheduleDto> schedules;
    @ManyToMany
    private List<CourseDto> courses;
    @ManyToMany
    private List<InscriptionDto> inscriptions;
    @OneToMany
    private List<ExamDto> exams;
    @OneToMany
    private Set<PaymentDto> payments ;

    public ParentDto getParent() {
        return parent;
    }

    public void setParent(ParentDto parent) {
        this.parent = parent;
    }

    public List<SchoolCareerDto> getSchoolCareers() {
        return schoolCareers;
    }

    public void setSchoolCareers(List<SchoolCareerDto> schoolCareers) {
        this.schoolCareers = schoolCareers;
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

    public List<InscriptionDto> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<InscriptionDto> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public List<ExamDto> getExams() {
        return exams;
    }

    public void setExams(List<ExamDto> exams) {
        this.exams = exams;
    }

    public Long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Set<PaymentDto> getPayments() {
        return payments;
    }

    public void setPayments(Set<PaymentDto> payments) {
        this.payments = payments;
    }
}
