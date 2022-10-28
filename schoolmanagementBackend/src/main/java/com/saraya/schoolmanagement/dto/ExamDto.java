package com.saraya.schoolmanagement.dto;

import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ExamDto implements Serializable{

    private Long id;
    private String observation;
    private String result;
    private String dateTime;
    private Double note;
    private String createdAt;
    private String updatedAt;
    @ManyToOne
    private SessionDto session;
    @ManyToOne
    private ExamTypeDto examType;
    @ManyToOne
    private StudentDto student;
    @ManyToOne
    private ModuleDto module;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public SessionDto getSession() {
        return session;
    }

    public void setSession(SessionDto session) {
        this.session = session;
    }

    public ExamTypeDto getExamType() {
        return examType;
    }

    public void setExamType(ExamTypeDto examType) {
        this.examType = examType;
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }

    public ModuleDto getModule() {
        return module;
    }

    public void setModule(ModuleDto module) {
        this.module = module;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
