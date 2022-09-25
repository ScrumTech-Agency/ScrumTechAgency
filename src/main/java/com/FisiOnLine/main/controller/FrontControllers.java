package com.FisiOnLine.main.controller;

import com.FisiOnLine.main.model.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontControllers {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){return "login";
    }

    //Controladores Transaction

    @GetMapping("/addtransaction")
    public String getAddTransaction (Model model){
        model.addAttribute("formTransaction", new Transaction());
        return "add-transaction-new";
    }

    @GetMapping("/wellcometransaction")
    public String getWellcomeTransaction (Model model){
        return "wellcome-transaction-new";
    }


    @PostMapping("/addtransaction")
    public String postAddTransaction (@ModelAttribute("formTransaction") Transaction transaction){
        System.out.println(transaction);
        return "redirect:/wellcometransaction";
    }



}
