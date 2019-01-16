package com.ludum.Ludum.model;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Tournament implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "hashtag")
    private String hashtag;

    @Column(name = "place")
    private String place;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "description")
    private String description;

    @Column(name = "login_orga")
    private String loginOrga;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
                name = "Participation",
                joinColumns = {@JoinColumn(name = "tournament_id") },
                inverseJoinColumns = {@JoinColumn (name = "team_id") }
    )
    List<Team> teams = new ArrayList<>();

    public Tournament(){}

    public Tournament(String theName, String theHashtag, String thePlace, Date theStartDate, Date theEndDate, String theDesc, String theOrga){
        name = theName;
        hashtag = theHashtag;
        place = thePlace;
        startDate = theStartDate;
        endDate = theEndDate;
        description = theDesc;
        loginOrga = theOrga;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }
}
