package com.example.model;

public class Address {
    private String city;
    private String zipCode;

    // this is a constructor
    public Address(String city, String zipCode) {
        this.city = city;
        this.zipCode = zipCode;
    }

    //getter
    public String getCity() {
        return city;
    }

    //setter
    public void setCity(String city) {
        this.city = city;
    }
    
    
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
