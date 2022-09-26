package com.FisiOnLine.main.service;

import com.FisiOnLine.main.model.Employee;
import com.FisiOnLine.main.model.Enterprise;
import com.FisiOnLine.main.model.Enum_RoleName;
import com.FisiOnLine.main.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class GestorTransaction {

    //Atributos
    private ArrayList<Transaction> transactions;

    //Constructor
    public GestorTransaction() {
        this.transactions = new ArrayList<>();
       // this.transactions.add(new Transaction(123,"Yoga",2000.5f, new Employee(123,"wilson","wash_30"/*, Enum_RoleName.Admin*/), new Enterprise(123456, "Scrumfisio","NIT808","30174282","Calle 24 A"), new java.sql.Date(2022-23-9),new Date()));
    }


    //Lógica del negocio

    public Transaction getTransaction(Long id) throws Exception {
        for (Transaction transaction: this.transactions) {
            if (transaction.getId() == id){
                return transaction;
            }
        }

        throw new Exception("La transacción que busca no existe");
    }

    public String setTransaction (Transaction transaction_parametro) throws Exception {
        try {
            getTransaction(transaction_parametro.getId());
        } catch (Exception e) {
            this.transactions.add(transaction_parametro);
            return "Transacción creada existosamente";
        }
        throw new Exception("La transacción ya existía, no se puede crear");
    }



    public Transaction updateTransaction(Transaction transaction_update, long id) throws Exception {
        try {
            Transaction transaction_bd = getTransaction(id);

        if(transaction_update.getConcept() != null && !transaction_update.getConcept().equals("")){
            transaction_bd.setConcept(transaction_update.getConcept());
        }
        if(transaction_update.getAmount() == 0.0f){
            transaction_bd.setAmount(transaction_update.getAmount());
        }
        if(transaction_update.getEmpleado() != null && !transaction_update.getEmpleado().equals("")){
            transaction_bd.setEmpleado(transaction_update.getEmpleado());
        }
        if(transaction_update.getEnterprise() != null && !transaction_update.getEnterprise().equals("")){
            transaction_bd.setEnterprise(transaction_update.getEnterprise());
        }
        if(transaction_update.getCreatedAt() != null && !transaction_update.getCreatedAt().equals("")){
            transaction_bd.setCreatedAt(transaction_update.getCreatedAt());
        }
        if(transaction_update.getUpdatedAt() != null && !transaction_update.getUpdatedAt().equals("")){
            transaction_bd.setUpdatedAt(transaction_update.getUpdatedAt());
        }

        return transaction_bd;

        } catch (Exception e) {
            throw new Exception("La transacción no existe, falló actualización de datos");
        }

    }

    public  Transaction updateTransactionAll(Transaction transaction_update, Long id) throws Exception {
        try {
            Transaction transaction_Bd = getTransaction(Long.valueOf(id));

            transaction_Bd.setId(transaction_update.getId());
            transaction_Bd.setConcept(transaction_update.getConcept());
            transaction_Bd.setAmount(transaction_update.getAmount());
            transaction_Bd.setEmpleado(transaction_update.getEmpleado());
            transaction_Bd.setEnterprise(transaction_update.getEnterprise());
            transaction_Bd.setCreatedAt(transaction_update.getCreatedAt());
            transaction_Bd.setUpdatedAt(transaction_update.getUpdatedAt());

            return transaction_Bd;
        } catch (Exception e) {
            throw new Exception("La transacción no existe, no se actualizó ningún dato");
        }
    }


    public String deleteTransaction (long id) throws Exception {
        try {
            Transaction transaction = getTransaction(id);
            this.transactions.remove(transaction);

            return "Transacción eliminada exitosamente";

        } catch (Exception e) {
            throw new Exception("La transacción que intenta eliminar no existe");
        }

    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }



}