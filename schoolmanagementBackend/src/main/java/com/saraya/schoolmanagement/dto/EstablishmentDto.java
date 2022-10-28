package com.saraya.schoolmanagement.dto;

import javax.persistence.OneToMany;
import java.util.List;
import java.io.Serializable;

public class EstablishmentDto implements Serializable{

    private Long id;
    private String name;
    private int ability;
    @OneToMany
    private List<RoomDto> rooms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAbility() {
        return ability;
    }

    public void setAbility(int ability) {
        this.ability = ability;
    }

    public List<RoomDto> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDto> rooms) {
        this.rooms = rooms;
    }
}
