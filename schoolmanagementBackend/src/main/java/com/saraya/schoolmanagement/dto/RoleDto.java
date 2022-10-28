package com.saraya.schoolmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saraya.schoolmanagement.enums.RoleName;
import com.saraya.schoolmanagement.models.User;

import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;
public class RoleDto implements Serializable{

    private Long id;

    private String roleName;

    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
