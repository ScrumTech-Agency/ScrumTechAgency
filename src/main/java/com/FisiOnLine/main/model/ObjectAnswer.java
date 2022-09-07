package com.FisiOnLine.main.model;

public class ObjectAnswer {
    //Atributos
    private Object object;
    private String message;



    //Constructor con atributos
    public ObjectAnswer(String message,Object object) {
        this.object = object;
        this.message = message;
    }

    //Constructor sin atributos
    public ObjectAnswer() {
    }

    //Setters and Getters

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
