package com.saraya.schoolmanagement.models;

import javax.persistence.*;
import java.util.Set;
import java.util.List;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private int number;
    private String name;
    private Double totalsAmount;
    @OneToMany(fetch = FetchType.EAGER,targetEntity = Inscription.class,cascade = CascadeType.ALL)
    private Set<Inscription> inscriptions;
    @OneToMany(fetch = FetchType.EAGER,targetEntity = Exam.class,cascade = CascadeType.ALL)
    private List<Exam> exams;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalsAmount() {
        return totalsAmount;
    }

    public void setTotalsAmount(Double totalsAmount) {
        this.totalsAmount = totalsAmount;
    }

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }
}
