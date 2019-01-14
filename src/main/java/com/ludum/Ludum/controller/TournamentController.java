package com.ludum.Ludum.controller;

import com.ludum.Ludum.model.Tournament;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class TournamentController {

    @GetMapping("/createTournament")
    public String createTournament(){
        return "create-tournament-page";
    }

    @GetMapping("/addTournament")
    public String addTournament(@RequestParam(name="name",defaultValue="No Name") String name,
                                @RequestParam(name="description",defaultValue="") String description,
                                @RequestParam(name="place") String place,
                                @RequestParam(name="startDate") Date startingDate,
                                @RequestParam(name="endDate") Date endingDate,
                                @RequestParam(name="hashtag") String hashtag){

        Tournament newTournament = new Tournament(name, description, place, startingDate, endingDate, hashtag, "admin");

        return "listTournaments";
    }
}
