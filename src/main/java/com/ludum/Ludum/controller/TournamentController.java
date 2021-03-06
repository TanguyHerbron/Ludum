package com.ludum.Ludum.controller;

import com.ludum.Ludum.model.Tournament;
import com.ludum.Ludum.repository.TournamentRepository;
import com.ludum.Ludum.twitterAPI.TwitterHashtagStream;
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
        model.addAttribute("tournamentForm", tournament);

        return "create-tournament-page";
    }

    @PostMapping("/addTournament")
    public String addTournamentSubmit(Model model, @ModelAttribute("tournamentForm") Tournament tournament, BindingResult result){
        if(!tournament.getHashtag().startsWith("#"))
        {
            tournament.setHashtag('#' + tournament.getHashtag());
        }
        
        tournamentDAO.save(tournament);
        model.addAttribute("tournament", tournament);

        //TwitterHashtagStream.getTweetStreamForHashtag("test");

        return "redirect:/displayTournament?tournamentId=" + tournament.getId();
    }
  
    @GetMapping("/displayTournament")
    public String displayTournaments(@RequestParam(name="tournamentId")Long id, Model model)
    {
        if(tournamentDAO.findById(id).isPresent())
        {
            model.addAttribute("tournament", tournamentDAO.findById(id).get());
        }

        return "tournament-page";
    }
}
