package com.example.Carabity.carabity.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY, visible = true)
//@JsonIgnoreProperties(value = "attributes",ignoreUnknown = true)

public class User {
    private String username;
    private String password;
    private String email;
    private int age;
    private ArrayList<String> newCars = new ArrayList<String>() ;
    private ArrayList<String> rentCars = new ArrayList<String>();
    private ArrayList<String> oldCars = new ArrayList<String>();
    private String status ;
    public User(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.age = user.getAge();
        //this.newCars = user.getNewCars() ;
//        newCars = new ArrayList<String>() ;
//        rentCars = new ArrayList<String >() ;
//        oldCars = new ArrayList<String>() ;
    }
    public User(){}
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<String> getNewCars() {
        return newCars;
    }

    public ArrayList<String> getOldCars() {
        return oldCars;
    }

    public ArrayList<String> getRentCars() {
        return rentCars;
    }

    public void setNewCars(ArrayList<String> newCars) {
        this.newCars = newCars;
    }

    public void setOldCars(ArrayList<String> oldCars) {
        this.oldCars = oldCars;
    }

    public void setRentCars(ArrayList<String> rentCars) {
        this.rentCars = rentCars;
    }

    public void addnew(String car){
        //System.out.println(this.email + " and we enter the user class" );
        newCars.add(car) ;
        //System.out.println(newCars);
    }
    public void addold(String car){
        System.out.println(oldCars.add(car));   ;
    }
    public void rent(String car){
        System.out.println(rentCars.add(car) );
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public void setNewCars(String newCars) {
//        this.newCars = newCars;
//    }

//    public String getNewCars() {
//        return newCars;
//    }
}