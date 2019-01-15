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

    @GetMapping("/createMatch")
    public String createMatch()
    {
        return "create-match-page";
    }

    @RequestMapping(value = "/addMatch", method = {RequestMethod.POST})
    public String addMatch(Model model, @ModelAttribute("createMatchFrom") Match match)
    {
        model.addAttribute("match", match);

        /*
        Prepare the associations between the tournament table and the match table
        Could need an autowired attribut for the inbetween table
         */

        return "match-page";
    }

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

        model.addAttribute("formMatch", new Match());

        return "listMatchs";
    }

    @PostMapping("/sendForm")
    public String recordMatch(@ModelAttribute Match match)
    {
        match.setIdMatch(matchRepository.count() + 1);
        match.setDate(new Date());
        match.setIdTournament(0L);
        matchRepository.save(match);

        return "submitConfirmation";
    }
}
