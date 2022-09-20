package com.FisiOnLine.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    //private Profile profileEmpl;
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Enum_RoleName.class )
    private List<Enum_RoleName> roleEmpl;
    @ManyToOne
    private Enterprise enterprise;
    @OneToMany(mappedBy = "empleado")
    private List<Transaction> transactions = new ArrayList<>();
    @JsonIgnore
    private Date updatedAt;
    @JsonIgnore
    private Date cratedAt;
    //private List<Enum_RoleName> roles;

    //Constructor

    public Employee(long idEmpl, String nameEmpl, String emailEmpl) {
        this.idEmpl = idEmpl;
        this.nameEmpl = nameEmpl;
        this.emailEmpl = emailEmpl;
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
        return cratedAt;
    }

    public void setCratedAt(Date cratedAt) {
        this.cratedAt = cratedAt;
    }

    /*public List<Enum_RoleName> getRoles() {
        return roles;
    }

    public void setRoles(List<Enum_RoleName> roles) {
        this.roles = roles;
    }*/
}

