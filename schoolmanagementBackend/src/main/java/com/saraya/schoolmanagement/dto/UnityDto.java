package com.saraya.schoolmanagement.dto;

import javax.persistence.OneToMany;
import java.util.List;
import java.io.Serializable;
public class UnityDto implements Serializable{

    private Long id;
    private String name;
    private Double credit;
    @OneToMany
    private List<ModuleDto> modules;

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

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public List<ModuleDto> getModules() {
        return modules;
    }

    public void setModules(List<ModuleDto> modules) {
        this.modules = modules;
    }
}
