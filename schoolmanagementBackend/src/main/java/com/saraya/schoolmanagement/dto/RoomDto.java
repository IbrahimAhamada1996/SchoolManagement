package com.saraya.schoolmanagement.dto;

import javax.persistence.ManyToOne;
import java.io.Serializable;
public class RoomDto implements Serializable{

    protected Long id;
    protected String designation;
    protected String number;

    @ManyToOne
    protected EstablishmentDto establishment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public EstablishmentDto getEstablishment() {
        return establishment;
    }

    public void setEstablishment(EstablishmentDto establishment) {
        this.establishment = establishment;
    }
}
