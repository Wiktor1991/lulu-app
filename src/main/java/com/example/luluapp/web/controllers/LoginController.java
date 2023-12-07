package com.example.luluapp.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "form-login";
    }
    @GetMapping("/out")
    public String logout(){
        return "logout";
    }
}
