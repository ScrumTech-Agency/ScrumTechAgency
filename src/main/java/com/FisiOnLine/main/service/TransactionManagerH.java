package com.FisiOnLine.main.service;

import com.FisiOnLine.main.Repositories.TransactionRepository;
import com.FisiOnLine.main.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionManagerH implements TransactionManagerInterface{
    ArrayList<Float> totalTransaction = new ArrayList<Float>();
    @Autowired
    private TransactionRepository repository;

    @Override
    public List<Transaction> getTransactions() {
        return repository.findAll();
    }

    @Override
    public Transaction getTransaction(Long id) throws Exception {
        Optional<Transaction> transactionBd = repository.findById(id);
        if (transactionBd.isPresent()) {
            return transactionBd.get();
        }
        throw  new Exception("La transacción no existe");
    }

    @Override
    public String setTransaction(Transaction transactions) throws Exception {
        //System.out.println(transactions.getRoleTransaction());
        //Se obtine el String del rol para aplicar logica del ingreso y egreso
        String validarRol = transactions.getRoleTransaction().toString();
        System.out.println(validarRol);
        //Se crea arraylist de float para guardar los montos


        if( validarRol.equals("[Ingreso]")){
            transactions.setAmount(transactions.getAmount());

            totalTransaction.add(transactions.getAmount());
           System.out.println("Esto es un ingreso" + totalTransaction);

            repository.save(transactions);
        }
        if(validarRol.equals("[Gasto]")){
            transactions.setAmount(transactions.getAmount()*-1);
            totalTransaction.add(transactions.getAmount());
            System.out.println("Esto es un Gasto"+ totalTransaction);
           repository.save(transactions);
        }
        float sumTotalTransaction=0;
        for (float suma:totalTransaction){
            sumTotalTransaction+=suma;
        }
        transactions.setTotalTransaction(sumTotalTransaction);
        System.out.println(transactions.getTotalTransaction());
        return "Transacción creada exitosamente";
    }

    @Override
    public Transaction UpdateTransactionAll(Transaction TransactionUpdate, Long id) throws Exception {
        return null;
    }

    @Override
    public Transaction UpdateTransaction(Transaction TransactionUpdate, Long id) throws Exception {
        Transaction transaction_Bd = getTransaction(id);
        if(TransactionUpdate.getConcept() != null && !TransactionUpdate.getConcept().equals("")){
            transaction_Bd.setConcept(TransactionUpdate.getConcept());
        }
        if(TransactionUpdate.getAmount() == 0.0f){
            transaction_Bd.setAmount(TransactionUpdate.getAmount());
        }
        if(TransactionUpdate.getEmpleado() != null && !TransactionUpdate.getEmpleado().equals("")){
            transaction_Bd.setEmpleado(TransactionUpdate.getEmpleado());
        }
        if(TransactionUpdate.getEnterprise() != null && !TransactionUpdate.getEnterprise().equals("")){
            transaction_Bd.setEnterprise(TransactionUpdate.getEnterprise());
        }
        if(TransactionUpdate.getCreatedAt() != null && !TransactionUpdate.getCreatedAt().equals("")){
            transaction_Bd.setCreatedAt(TransactionUpdate.getCreatedAt());
        }
        if(TransactionUpdate.getUpdatedAt() != null && !TransactionUpdate.getUpdatedAt().equals("")){
            transaction_Bd.setUpdatedAt(TransactionUpdate.getUpdatedAt());
        }

        return repository.save(transaction_Bd);
    }

    @Override
    public String DeleteTransaction(Long id) throws Exception {
        repository.deleteById(id);
        return "Transacción Eliminada Exitosamente";
    }

   /* private void ingressEgressManager(Transaction transactions) {
        String validarRol = transactions.getRoleTransaction().toString();
        System.out.println(validarRol);
        List gastoTotal = new ArrayList<>();
        List ingresoTotal = new ArrayList<>();
        if( validarRol.equals("[Ingreso]")){
            transactions.setAmount(transactions.getAmount());
            System.out.println("Esto es un ingreso");
            ingresoTotal.add(transactions.getAmount());
            float suma=0;
            for (int i = 0; i < ingresoTotal.size(); i++) {
                suma = suma + i;
            }
            System.out.println(suma);
            repository.save(transactions);
        }
        if(validarRol.equals("[Gasto]")){
            transactions.setAmount(transactions.getAmount()*-1);
            gastoTotal.add(transactions.getAmount()*-1);
            System.out.println("Esto es un Gasto");

            repository.save(transactions);
        }
    }*/


}
