package com.example.projectSurf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

//    @GetMapping("/lessons")
//    public String lessons(){
//        return "lessons";
//    }
}
