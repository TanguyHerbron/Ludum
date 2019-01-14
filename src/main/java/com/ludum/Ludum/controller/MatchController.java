package com.ludum.Ludum.controller;

import com.ludum.Ludum.model.Match;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MatchController {

    @GetMapping("/createMatch")
    public String createMatch()
    {
        return "create-match-page";
    }

    @RequestMapping(value = "/addMatch", method = {RequestMethod.POST})
    public String addMatch(Model model, @ModelAttribute("createMatchFrom") Match match)
    {
        model.addAttribute("match", match);
        return "match-page";
    }

    @GetMapping("/displayMatchsFor")
    public String displayMatchs()
    {
        return "listMatchs";
    }
}
