package com.saraya.schoolmanagement.dto;

import javax.persistence.OneToMany;
import java.util.List;
import java.io.Serializable;
public class SessionDto implements Serializable{
    private Long id;
    private int number;
    private String name;
    private Double totalsAmount;
    @OneToMany
    private List<InscriptionDto> inscriptions;
    @OneToMany
    private List<ExamDto> exams;

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
}
