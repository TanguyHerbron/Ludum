package com.ludum.Ludum.controller;

import com.ludum.Ludum.model.Person;
import com.ludum.Ludum.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private PersonRepository personDAO;

    @GetMapping("/index")
    public String login(Model model){

        return "index";
    }

    @GetMapping("/register")
    public String register(Model model){
        Person person = new Person();
        model.addAttribute("registerForm", person);

        return "create-account-page";
    }

    @PostMapping("/register")
    public String registerForm(@ModelAttribute("registerForm") Person person){
        System.out.println(person.getPassword());
        System.out.println(person.getPassword().equals(person.getConfirmPassword()));
        if(!person.getPassword().equals(person.getConfirmPassword()))
        {
            return "create-account-page";
        }
        else
        {
            personDAO.save(person);
            return "index";
        }

    }

}
