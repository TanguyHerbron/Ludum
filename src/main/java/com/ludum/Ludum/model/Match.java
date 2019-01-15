package com.ludum.Ludum.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Date;

@Entity
public class Match {

    @Id
    private Long idMatch;

    private Date date;

    private String location;

    private Long idTournament;

    public Long getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(Long idMatch) {
        this.idMatch = idMatch;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setIdTournament(Long idTournament) {
        this.idTournament = idTournament;
    }

    public Long getIdTournament()
    {
        return idTournament;
    }
}
