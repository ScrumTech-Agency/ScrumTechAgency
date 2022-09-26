package com.FisiOnLine.main.controller;

import com.FisiOnLine.main.model.Employee;
import com.FisiOnLine.main.model.Enum_RoleTransaction;
import com.FisiOnLine.main.model.Transaction;
import com.FisiOnLine.main.service.EmployeeManagerInterface;
import com.FisiOnLine.main.service.EnterpriseManagerInterface;
import com.FisiOnLine.main.service.TransactionManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FrontControllerTransaction {

    @Autowired
    private TransactionManagerInterface gestorTransaction;

    @Autowired
    private EmployeeManagerInterface gestorEmployee;

    @GetMapping("/addtransaction")
    public String getAddTransaction (Model model){
        model.addAttribute("formTransaction", new Transaction());
        model.addAttribute("rolesList", Enum_RoleTransaction.values());
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

    @RequestMapping(value = "/transaction/front/{id}", method = RequestMethod.GET)
    public String deleteTransaction (@PathVariable (name = "id") Long id) {
        try {
            gestorTransaction.DeleteTransaction(id);
            return "redirect:/wellcometransaction";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @GetMapping("/updatetransaction")
    public String getUpdateTransaction (Model model){
        model.addAttribute("formUpdateTransaction", new Transaction());
        model.addAttribute("rolesList", Enum_RoleTransaction.values());
        return "update-transaction";
    }



    @GetMapping("/transaction/update/{id}")
    public String getUpdateTransaction (@PathVariable Long id, Model model){
        try {
            System.out.println(id);
            System.out.println(gestorTransaction.getTransaction(id));
            model.addAttribute("formUpdateTransaction",gestorTransaction.getTransaction(id));
            model.addAttribute("rolesList", Enum_RoleTransaction.values());
            return "update-transaction";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }

    /*
    @PatchMapping("/transaction/update/register")
    public String postUpateTransaction (@ModelAttribute("formUpdateTransaction") Transaction transaction_parametro){
        try {
            String mensaje = gestorTransaction.setTransaction(transaction_parametro);
            return "redirect:/wellcometransaction";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }

     */

    @PostMapping("/transaction/update/register")
    public String patchTransaction(@ModelAttribute("formUpdateTransaction") Transaction transactionParametro){
        try {
            System.out.println(transactionParametro);
            gestorTransaction.UpdateTransaction(transactionParametro,transactionParametro.getId());
            return "redirect:/wellcometransaction";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }



}
