package com.ludum.Ludum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam
                                   (name="nameGET", required=false, defaultValue="World")
                                   String nameGet, Model model)
    {
        model.addAttribute("index", nameGet);
        return "greeting";
    }
}
