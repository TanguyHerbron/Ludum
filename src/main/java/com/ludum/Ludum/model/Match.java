package com.ludum.Ludum.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Match {
    @Id
    private Long idMatch;

    private Date date;

    private String location;

    private Long idTournoi;
}
