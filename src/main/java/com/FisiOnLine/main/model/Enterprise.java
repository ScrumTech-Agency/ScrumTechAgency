package com.FisiOnLine.main.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.catalina.User;

import javax.persistence.*;


@Entity
@Table(name="Empresas")
public class Enterprise {
    @Id
    private long idEnterprise;
    @Column
    private String name;
    @Column

    private String document;
    @Column
    private String phone;
    @Column
    private String address;

    //private User[] users;
    @OneToMany(mappedBy = "enterprise")
    private List<Transaction> transactions;

    @Column
    private Date createdAt;
    @Column
    private Date updateAt;
    @OneToMany(mappedBy = "enterprise")
    private List<Employee> employees;

    // constructor
    public Enterprise(long idEnterprise, String name, String document, String phone, String address) {
        this.idEnterprise = idEnterprise;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;

    }
    //constructor sin atributos
    public Enterprise() {
    }

    //getter y setter

    public long getIdEnterprise() {
        return idEnterprise;
    }

    public void setIdEnterprise(long idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /*public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }*/

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
