package com.FisiOnLine.main.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="transaction")
public class Transaction {
    //Atributos
    @Id
    private long id;
    @Column
    private String concept;
    @Column
    private float amount;
    @ManyToOne
    private Employee empleado;
    @ManyToOne
    private Enterprise enterprise;
    @Column
    private Date createdAt;
    @Column
    private Date updatedAt;

    //Constructor
    public Transaction(long id, String concept, float amount, Employee empleado, Enterprise enterprise, Date createdAt, Date updatedAt) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.empleado = empleado;
        this.enterprise = enterprise;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    //Constructor vacío
    public Transaction() {
    }

    //Set y get
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Employee getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Employee empleado) {
        this.empleado = empleado;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
