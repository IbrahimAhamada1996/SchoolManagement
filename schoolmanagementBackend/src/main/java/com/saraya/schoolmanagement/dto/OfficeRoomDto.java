package com.saraya.schoolmanagement.dto;

public class OfficeRoomDto extends RoomDto {
    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}