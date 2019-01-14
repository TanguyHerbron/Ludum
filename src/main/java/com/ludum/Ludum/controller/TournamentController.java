package com.ludum.Ludum.controller;

import com.ludum.Ludum.model.Tournament;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TournamentController {

    @GetMapping("/createTournament")
    public String createTournament(){
        return "create-tournament-page";
    }

    @RequestMapping(value = "/addTournament", method = {RequestMethod.POST})
    public String addTournament(Model model, @ModelAttribute("createTournamentForm") Tournament newTournament){

        model.addAttribute("tournament", newTournament);
        return "tournament-page";
    }
}
