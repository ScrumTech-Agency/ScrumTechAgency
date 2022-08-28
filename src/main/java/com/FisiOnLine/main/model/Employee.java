package com.FisiOnLine.main.model;

import java.util.Date;

public class Employee {
    //Atributos
    private long idEmpl;
    private String nameEmpl;
    private String emailEmpl;
    private Profile profileEmpl;
    private Enum_RoleName roleEmpl;
    private Enterprise enterprise;
    private Transaction [] transactions;
    private Date updatedAt;
    private Date cratedAt;

    //Constructor

    public Employee(String nameEmpl, String emailEmpl, Enum_RoleName roleEmpl, Enterprise enterprise) {
        super ();
        this.nameEmpl = nameEmpl;
        this.emailEmpl = emailEmpl;
        this.roleEmpl = roleEmpl;
        this.enterprise = enterprise;
    }

    //Constructor sin Atributos
    public Employee() {
    }

    //Getters y Setters
    public long getIdEmpl() {
        return idEmpl;
    }

    public void setIdEmpl(long idEmpl) {
        this.idEmpl = idEmpl;
    }

    public String getNameEmpl() {
        return nameEmpl;
    }

    public void setNameEmpl(String nameEmpl) {
        this.nameEmpl = nameEmpl;
    }

    public String getEmailEmpl() {
        return emailEmpl;
    }

    public void setEmailEmpl(String emailEmpl) {
        this.emailEmpl = emailEmpl;
    }

    public Profile getProfileEmpl() {
        return profileEmpl;
    }

    public void setProfileEmpl(Profile profileEmpl) {
        this.profileEmpl = profileEmpl;
    }

    public Enum_RoleName getRoleEmpl() {
        return roleEmpl;
    }

    public void setRoleEmpl(Enum_RoleName roleEmpl) {
        this.roleEmpl = roleEmpl;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCratedAt() {
        return cratedAt;
    }

    public void setCratedAt(Date cratedAt) {
        this.cratedAt = cratedAt;
    }
}

