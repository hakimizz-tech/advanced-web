package com.example.model;

import java.io.Serializable;

//a java bean - reusable software components
public class Product  implements Serializable{
    
    //all properties are privae
    private int id;
    private String name;
    private double price;

    //public no-argument constructor
    public Product(){}

    //define getter and setters for each property

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName(){return this.name;}
    public void setName(String name) {this.name = name;}

    public double getPrice(){return this.price;}
    public void setPrice(double price){this.price = price;}

}
