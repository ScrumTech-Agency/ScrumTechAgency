package com.FisiOnLine.main.controller;

import com.FisiOnLine.main.model.Employee;
import com.FisiOnLine.main.model.Enum_RoleName;
import com.FisiOnLine.main.service.EmployeeManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class FrontControllerEmployee {
    @Autowired
    private EmployeeManagerInterface employeeManager;

    @GetMapping("/welcome-employee")
    public String getWelcome(Model model) {
        model.addAttribute("rol", Enum_RoleName.ROLE_ADMIN);
        model.addAttribute("employees", employeeManager.getEmployees());
        return "welcome-employee-new";
    }

    @GetMapping("/addemployee")
    public String getAddEmployee(Model model){
        model.addAttribute("employeeRegister", new Employee());
        model.addAttribute("rolesList",Enum_RoleName.values());
        return "add-employee-new";
    }
    @PostMapping("/employee/register")
        public String postEmployee(@ModelAttribute("employeeRegister") @DateTimeFormat(pattern = "YYYY-MM-DD") Employee employeeParametro) {
        try {
            String mensaje = employeeManager.setEmployee(employeeParametro);
            return "redirect:/welcome-employee";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @GetMapping("/updateUser")
    public String getUpdateUser(Model model){
        System.out.println(model.getAttribute("userUpdate"));
        return "update-employee";
    }
    @GetMapping("/employee/update/{id}")
    public String getUsuario(@PathVariable Long id, Model model){
        try {
            System.out.println(id);
            System.out.println(employeeManager.getEmployee(id));
            model.addAttribute("userUpdate",employeeManager.getEmployee(id));
            model.addAttribute("rolesList", Enum_RoleName.values());
            return "update-employee-new";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }

    @PutMapping("/employee/front/update")
    public String putUsuario(@ModelAttribute("userUpdate") Employee employeeParametro){
        try {
            System.out.println(employeeParametro);
            employeeManager.UpdateEmployee(employeeParametro,employeeParametro.getIdEmpl());
            return "redirect:/welcome-employee";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }
    @DeleteMapping("/employee/front/{id}")
    public String deleteUser(@PathVariable Long id, Model model){
        try {
            employeeManager.DeleteEmployee(id);
            return "redirect:/welcome-employee";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }



}
