package com.ludum.Ludum.controller;

import com.ludum.Ludum.model.Match;
import com.ludum.Ludum.repository.TournamentRepository;
import com.ludum.Ludum.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MatchController {

    @Autowired
    TournamentRepository tournamentRepository;

    @Autowired
    MatchRepository matchRepository;

    @GetMapping("/displayMatchsFor")
    public String displayMatchs(@RequestParam(name="tournamentId")Long tournamentId, Model model)
    {
        List<Match> matchs = new ArrayList<>();

        for(Match match : matchRepository.findAll())
        {
            if(match.getIdTournament().equals(tournamentId))
            {
                matchs.add(match);
            }
        }

        model.addAttribute("allMatchs", matchs);

        return "match-page";
    }
}
