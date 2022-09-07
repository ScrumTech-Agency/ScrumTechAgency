package com.FisiOnLine.main.controller;

import com.FisiOnLine.main.model.Transaction;
import com.FisiOnLine.main.service.GestorTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionControlador {

    @Autowired
    private GestorTransaction gestorTransaction;

    @GetMapping("/enterprises/{id}/movements")
    public ResponseEntity<Object> getTransaction (@PathVariable long id){
        try {
            Transaction transaction = gestorTransaction.getTransaction(id);
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/enterprises/{id}/movements")
    public ResponseEntity<String> postTransaction (@RequestBody Transaction transaction_parametro){
        try {
            String mensaje = gestorTransaction.setTransaction(transaction_parametro);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PatchMapping("/enterprises/{id}/movements")
    public ResponseEntity<Object> patchTransaction(@RequestBody Transaction transaction_update, @PathVariable long id){

        try {
            Transaction transaction_bd = gestorTransaction.updateTransaction(transaction_update, id);
            return new ResponseEntity<>(transaction_bd, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/enterprises/{id}/movements")
    public ResponseEntity<Object> deleteTransaction(@PathVariable long id){

        try {
            String mensaje = gestorTransaction.deleteTransaction(id);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
