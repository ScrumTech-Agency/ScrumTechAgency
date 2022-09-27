package com.FisiOnLine.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Employee")
public class Employee {


    //Atributos de la Clase
    @Id
    private long idEmpl;
    @Column
    private String nameEmpl;
    @Column
    private String emailEmpl;
    @Column
    private String password;

    //private Profile profileEmpl;
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Enum_RoleName.class, fetch = FetchType.EAGER)
    private List<Enum_RoleName> roleEmpl;
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Enterprise enterprise;
    @OneToMany(mappedBy = "empleado")
    private List<Transaction> transactions;
    @Column
    private Date updatedAt;
    @Column
    private Date createdAt;
   


    //Constructor

    public Employee(long idEmpl, String nameEmpl, String emailEmpl, String password, List<Enum_RoleName> roleEmpl, Enterprise enterprise, Date createdAt) {
        this.idEmpl = idEmpl;
        this.nameEmpl = nameEmpl;
        this.emailEmpl = emailEmpl;
        this.password = password;
        this.roleEmpl = roleEmpl;
        this.enterprise = enterprise;
        this.createdAt = createdAt;
    }

    public Employee(long idEmpl, String nameEmpl, String emailEmpl, String password) {
        this.idEmpl = idEmpl;
        this.nameEmpl = nameEmpl;
        this.emailEmpl = emailEmpl;
        this.password = password;
        //this.roleEmpl = roleEmpl;

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

    /*public Profile getProfileEmpl() {
        return profileEmpl;
    }

    public void setProfileEmpl(Profile profileEmpl) {
        this.profileEmpl = profileEmpl;
    }*/

    public List<Enum_RoleName> getRoleEmpl() {
        return roleEmpl;
    }

    public void setRoleEmpl(List<Enum_RoleName> roleEmpl) {
        this.roleEmpl = roleEmpl;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCratedAt() {
        return createdAt;
    }

    public void setCratedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}

