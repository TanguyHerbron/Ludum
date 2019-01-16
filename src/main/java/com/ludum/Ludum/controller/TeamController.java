package com.ludum.Ludum.controller;

import com.ludum.Ludum.model.Team;
import com.ludum.Ludum.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TeamController {
    @Autowired
    TeamRepository teamRepository;

    @GetMapping("/list-team-page")
    public String listTeamPage(){
        return "list-team-page";
    }

    @GetMapping("/team-page")
    public String teamPage(@RequestParam(name="teamId")Long id, Model model){

        if(teamRepository.findById(id).isPresent())
        {
            model.addAttribute("team", teamRepository.findById(id).get());
        }

        return "team-page";
    }

    @GetMapping("/create-team-page")
    public String createTeamPage(Model model){
        model.addAttribute("team", new Team());
        return "create-team-page";
    }

    @PostMapping("/create-team-page")
    public String createTeamSubmit(Model model, @ModelAttribute("teamForm") Team team) {
        teamRepository.save(team);
        return "redirect:/team-page?teamId=" + team.getId();
    }

    @RequestMapping(value = "/delete-team", method = {RequestMethod.POST})
    public String deleteTeam(Model model, @ModelAttribute("deleteTeamForm") Team newTeam){

        model.addAttribute("team", newTeam);
        return "team-page";
    }
}
