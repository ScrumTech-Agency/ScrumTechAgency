package com.FisiOnLine.main.controller;

import com.FisiOnLine.main.model.Employee;
import com.FisiOnLine.main.model.Transaction;
import com.FisiOnLine.main.service.GestorTransaction;
import com.FisiOnLine.main.service.TransactionManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerTransaction {

    @Autowired
    private TransactionManagerInterface gestorTransaction;

    @GetMapping("/movements")
    public ResponseEntity <List<Transaction>>getTransactions(){
        return new ResponseEntity<>(gestorTransaction.getTransactions(), HttpStatus.ACCEPTED);
    }


    @GetMapping("/enterprises/{id}/movement")
    public ResponseEntity<Object> getTransaction (@PathVariable Long id){
        try {
            Transaction transaction = gestorTransaction.getTransaction(id);
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/enterprises/{id}/movement")
    public ResponseEntity<String> postTransaction (@RequestBody Transaction transaction_parametro){
        try {
            String mensaje = gestorTransaction.setTransaction(transaction_parametro);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PatchMapping("/enterprises/{id}/movement")
    public ResponseEntity<Object> patchTransaction(@RequestBody Transaction transaction_update, @PathVariable Long id){

        try {
            Transaction transaction_bd = gestorTransaction.UpdateTransaction(transaction_update, id);
            return new ResponseEntity<>(transaction_bd, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/enterprises/{id}/movement")
    public ResponseEntity<Object> deleteTransaction(@PathVariable Long id){

        try {
            String mensaje = gestorTransaction.DeleteTransaction(id);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
