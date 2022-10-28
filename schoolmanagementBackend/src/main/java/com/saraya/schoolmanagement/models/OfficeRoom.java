package com.saraya.schoolmanagement.models;

import javax.persistence.Entity;

@Entity
public class OfficeRoom extends Room{
    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}

