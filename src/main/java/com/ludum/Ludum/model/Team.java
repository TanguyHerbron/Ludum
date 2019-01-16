package com.ludum.Ludum.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team {

    @Id
    private Long idTeam;

    private String name;
    private String city;

    public Long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Long idTeam) {
        this.idTeam = idTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
