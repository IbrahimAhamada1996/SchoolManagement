package com.saraya.schoolmanagement.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Double amount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String type;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<DeadLine> deadLines;
    @ManyToOne(fetch = FetchType.LAZY)
    private Inscription inscription;

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<DeadLine> getDeadLines() {
        return deadLines;
    }

    public void setDeadLines(Set<DeadLine> deadLines) {
        this.deadLines = deadLines;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
