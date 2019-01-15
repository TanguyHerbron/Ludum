package com.ludum.Ludum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeamController {
    @GetMapping("/team-page")
    public String teamPage(){
        return "team-page";
    }
}
