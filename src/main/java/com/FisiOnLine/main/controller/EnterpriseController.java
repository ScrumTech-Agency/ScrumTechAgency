package com.FisiOnLine.main.controller;

import com.FisiOnLine.main.model.Enterprise;
import com.FisiOnLine.main.service.EnterpriseManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class EnterpriseController {
    @Autowired
    private EnterpriseManagerInterface EnterpriseBDX;

    //Metodos para crear un Enterprise

    @GetMapping("/EnterpriseRegisterNew")
    public String getEnterpriseRegister(Model model){
        model.addAttribute("formEnterpriseRegister",new Enterprise());
        return "EnterpriseRegister";
    }

    @PostMapping("/CreateEnterpriseNew")
    public String CreateEnterprise (@ModelAttribute("redirect:/WelcomeEnterprise") Enterprise EnterpriseX) throws Exception {
        String AnswerCreateEnterprise = EnterpriseBDX.setCreateEnterprise(EnterpriseX);
        return AnswerCreateEnterprise;
    }


    //Metodo para listar Enterprise

    @GetMapping("/welcomeEnterprise")
    public String getUserList(Model model){
        model.addAttribute("Enterprise",EnterpriseBDX.getEnterpriseX());
        List<Enterprise> ExEnterprise = EnterpriseBDX.getEnterpriseX();
        System.out.println(ExEnterprise);
        return "WelcomeEnterpriseNew";
    }


    //Metodo para borrar un Enterprise
    @PostMapping("/deleteEnterprise/{idEnterprise}")
    public String deleteEnterprise(@PathVariable Long idEnterprise, Model model){
        try {
            EnterpriseBDX.DeleteEnterprise(idEnterprise);
            return "redirect:/WelcomeEnterprise";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    //Metodo para actualizar un Enterprise

    @GetMapping("/updateEnterprise/{idEnterprise}")
    public String updateEnterprise(@PathVariable Long idEnterprise, Model model){
        try {
            model.addAttribute("EnterpriseUpdate",EnterpriseBDX.getOnlyEnterprise(idEnterprise));
            return "updateEnterpriseNew";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @PostMapping("/updateEnterprise")
    public String updateEnterprise (@ModelAttribute("redirect:/WelcomeEnterprise") Enterprise EnterpriseX){
        try {
            EnterpriseBDX.UpdateEnterpriseAll(EnterpriseX);
            return "redirect:/WelcomeEnterprise";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }

    //Metodo para presentar empleados de la empresa
    @GetMapping("/EmployeeOfEnterprise/{idEnterprise}")
    public String EmployeeOfEnterprise(@PathVariable Long idEnterprise, Model model){
        try {
            Enterprise EnterpriseX = EnterpriseBDX.getOnlyEnterprise(idEnterprise);
            model.addAttribute("EmployeesEnterprise",EnterpriseX.getEmployees());
            return "EmployeesOfEnterprise";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

}
