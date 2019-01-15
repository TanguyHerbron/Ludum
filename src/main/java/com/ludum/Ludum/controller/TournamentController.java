package com.ludum.Ludum.controller;

import com.ludum.Ludum.model.Tournament;
import com.ludum.Ludum.model.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class TournamentController {

    @Autowired
    private TournamentRepository tournamentDAO;


    @GetMapping("/addTournament")
    public String addTournamentForm(Model model) {

        Tournament tournament = new Tournament();
        tournament.setName("test");
        model.addAttribute("tournamentForm", tournament);

        return "create-tournament-page";
    }

    @PostMapping("/addTournament")
    public String addTournamentSubmit(Model model, @ModelAttribute("tournamentForm") Tournament tournament, BindingResult result){

        System.out.println(tournament.getName() + model.containsAttribute("name"));
        tournamentDAO.save(tournament);
        return "tournament-page";
    }



}
