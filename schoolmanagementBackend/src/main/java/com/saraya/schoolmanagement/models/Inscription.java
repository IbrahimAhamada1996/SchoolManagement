package com.saraya.schoolmanagement.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String year;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToMany(targetEntity = Student.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "INSCRIPTION_ID", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id")}
    )
    private Set<Student> students;
    @OneToMany(fetch = FetchType.EAGER,targetEntity = Payment.class,cascade = CascadeType.ALL)
    private Set<Payment> payments;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Session.class)
    private Session session;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Faculty.class)
    private Faculty faculty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
