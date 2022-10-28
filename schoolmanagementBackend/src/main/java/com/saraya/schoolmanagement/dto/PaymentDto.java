package com.saraya.schoolmanagement.dto;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.io.Serializable;
public class PaymentDto implements Serializable{

    private Long id;
    private Double amount;
    private String createdAt;
    private  String updatedAt;
    private String type;
    @OneToMany
    private List<DeadLineDto> deadLines;
    @ManyToOne
    private InscriptionDto inscription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<DeadLineDto> getDeadLines() {
        return deadLines;
    }

    public void setDeadLines(List<DeadLineDto> deadLines) {
        this.deadLines = deadLines;
    }

    public InscriptionDto getInscription() {
        return inscription;
    }

    public void setInscription(InscriptionDto inscription) {
        this.inscription = inscription;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
