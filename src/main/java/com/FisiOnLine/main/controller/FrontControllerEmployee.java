package com.FisiOnLine.main.controller;

import com.FisiOnLine.main.model.Employee;
import com.FisiOnLine.main.service.EmployeeManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontControllerEmployee {
    @Autowired
    private EmployeeManagerInterface employeeManager;

    @GetMapping("/welcome")
    public String getWelcome(Model model) {
        model.addAttribute("employees", employeeManager.getEmployees());
        return "welcome";
    }

    @GetMapping("/addemployee")
    public String getAddEmployee(Model model){
        model.addAttribute("employeeRegister", new Employee());
        return "add-employee";
    }
    @PostMapping("/employee/register")
        public String postEmployee(@ModelAttribute("employeeRegister") Employee employeeParametro) {
        try {
            String mensaje = employeeManager.setEmployee(employeeParametro);
            return "redirect:/welcome";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }




}
