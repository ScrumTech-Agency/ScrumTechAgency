package com.FisiOnLine.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontControllers {

    @GetMapping("/")
    public String index(){
        return "index-new";
    }

    @GetMapping("/login")
    public String login(){return "login";
    }

}
