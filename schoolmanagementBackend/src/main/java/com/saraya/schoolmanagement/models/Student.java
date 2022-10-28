package com.saraya.schoolmanagement.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("student")
public class Student extends User{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    private Parent parent;
    @ManyToMany(targetEntity = SchoolCareer.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "SCHOOL_SCHEDULE_ID", referencedColumnName = "id")}
    )
    private Set<SchoolCareer> schoolCareers;
    @ManyToMany(targetEntity = Schedule.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "SCHEDULE_ID", referencedColumnName = "id")}
    )
    private Set<Schedule> schedules;
    @ManyToMany(targetEntity = Course.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "COURSE_ID", referencedColumnName = "id")}
    )
    private Set<Course> courses;
    @ManyToMany(targetEntity = Exam.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "INSCRIPTION_ID", referencedColumnName = "id")}
    )
    private Set<Inscription> inscriptions;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Exam> exams;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Payment> payments ;

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Set<SchoolCareer> getSchoolCareers() {
        return schoolCareers;
    }

    public void setSchoolCareers(Set<SchoolCareer> schoolCareers) {
        this.schoolCareers = schoolCareers;
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

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public Set<Exam> getExams() {
        return exams;
    }

    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }

    public Long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }
}
