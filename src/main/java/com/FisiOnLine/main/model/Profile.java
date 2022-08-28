package com.FisiOnLine.main.model;

import org.apache.catalina.User;

import java.util.Date;

public class Profile {
    //Atributos
    private String id;
    private String image;
    private String phone;
    private User user;
    private Date createdAt;
    private Date ubdatedAt;

    //Constructor
    public Profile(String id, String image, String phone, User user, Date createdAt, Date ubdatedAt) {
        this.id = id;
        this.image = image;
        this.phone = phone;
        this.user = user;
        this.createdAt = createdAt;
        this.ubdatedAt = ubdatedAt;
    }

    //Creamos constructor sin atributos

    public String getId() {
        return id;
    }

    //Creamos los Getters and Setters

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUbdatedAt() {
        return ubdatedAt;
    }

    public void setUbdatedAt(Date ubdatedAt) {
        this.ubdatedAt = ubdatedAt;
    }
}
