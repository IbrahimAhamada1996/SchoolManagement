package com.saraya.schoolmanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saraya.schoolmanagement.enums.RoleName;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {

    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ROLE_NAME")
   /* @Enumerated(EnumType.STRING)
    @NaturalId*/
    private String roleName;

    @ManyToMany(targetEntity = User.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")},
            inverseJoinColumns = {
                    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")}
    )
    @JsonIgnore
    private Set<User> users ;

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
