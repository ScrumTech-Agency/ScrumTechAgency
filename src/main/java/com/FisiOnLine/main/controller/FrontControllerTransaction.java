package com.FisiOnLine.main.controller;

import com.FisiOnLine.main.model.Employee;
import com.FisiOnLine.main.model.Transaction;
import com.FisiOnLine.main.service.EmployeeManagerInterface;
import com.FisiOnLine.main.service.EnterpriseManagerInterface;
import com.FisiOnLine.main.service.TransactionManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontControllerTransaction {

    @Autowired
    private TransactionManagerInterface gestorTransaction;

    @Autowired
    private EmployeeManagerInterface gestorEmployee;

    @GetMapping("/addtransaction")
    public String getAddTransaction (Model model){
        model.addAttribute("formTransaction", new Transaction());
        //model.addAttribute("formEmployee", gestorEmployee.getEmployee(id).getIdEmpl());
        return "add-transaction-new";
    }

    @GetMapping("/wellcometransaction")
    public String getWellcomeTransaction (Model model){
        model.addAttribute("transactions",gestorTransaction.getTransactions());
        return "wellcome-transaction-new";
    }


    @PostMapping("/transaction/register")
    public String postAddTransaction (@ModelAttribute("formTransaction") Transaction transaction_parametro){
        try {
            String mensaje = gestorTransaction.setTransaction(transaction_parametro);
            return "redirect:/wellcometransaction";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }



    /*
    @PostMapping("/transaction/register")
    public String postAddTransaction (@ModelAttribute("formTransaction") Transaction transaction_parametro){
        try {
            String mensaje = gestorTransaction.setTransaction(transaction_parametro);
            return "redirect:/wellcometransaction";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }
     */





}
