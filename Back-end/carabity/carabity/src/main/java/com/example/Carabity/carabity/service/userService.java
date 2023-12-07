package com.example.Carabity.carabity.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class userService {
    private readAndWriteData r = readAndWriteData.getInstance() ;
    private User currentuser ;
    public userService() throws IOException {
        r.loadToJson("E:\\material\\2nd year\\1st semester\\HCI\\carabity\\Web\\Back-end\\users.json");

    }
    public User signup(User user) throws IOException {
        if (checkEmail(user)){
            user.setStatus("This email is alraedy exist!");
            return user;
        }
        if (checkUsername(user)){
            user.setStatus("This username is alraedy exist!");
            return user;
        }
        user.setStatus("Successfully signed");
        r.add(user);
        this.currentuser = user ;
        return user ;
    }
    public User signin(User user) throws IOException {
        if (!checkEmail(user)){
            user.setStatus("This email is not exist");
            return user;
        }
        user = checkPassword(user);
        if (user==null){
            user.setStatus("Invalid password");
            return user;
        }
        user.setStatus("Successfully signed");
        this.currentuser = user ;
        System.out.println(currentuser.getEmail());
        return user ;
    }
    public void addNewcar(String newCar) throws IOException {
        System.out.println(currentuser.getUsername());
        currentuser.addnew(newCar);
        for (User u: r.getUsers()  ) {
            if(u.getEmail().equals(currentuser.getEmail()) ){
                u.setNewCars( currentuser.getNewCars() ) ;
                r.saveToJson();
                return ;
            }
        }
    }
    public void addOldcar(String newCar) throws IOException {
        System.out.println(currentuser.getUsername());
        currentuser.addold(newCar);
        System.out.println(currentuser.getOldCars());
        for (User u: r.getUsers()  ) {
            if(u.getEmail().equals(currentuser.getEmail()) ){
                u.setOldCars(currentuser.getOldCars())  ;
                r.saveToJson();
                return ;
            }
        }
    }
    public void addrent(String newCar) throws IOException {
        System.out.println(currentuser.getUsername());
        currentuser.rent(newCar);
        for (User u: r.getUsers()  ) {
            if(u.getEmail().equals(currentuser.getEmail()) ){
                u.setRentCars( currentuser.getRentCars() ) ;
                r.saveToJson();
                return ;
            }
        }
    }

    public User checkPassword(User user){
        for (User u: r.getUsers()  ) {
            if(u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword()))
                return u ;
        }
        return null ;
    }

    public boolean checkEmail(User user){
        for (User u: r.getUsers()  ) {
            if(u.getEmail().equals(user.getEmail()))
                return true ;
        }
        return false ;
    }
    public boolean checkUsername(User user){
        for (User u: r.getUsers()  ) {
            if(u.getUsername().equals(user.getUsername()))
                return true ;
        }
        return false ;
    }
    public ArrayList<User> loadAll() throws IOException {

        String path = "E:\\material\\2nd year\\1st semester\\HCI\\carabity\\Web\\Back-end\\users.json";
        return r.loadToJson(path);
    }

    public User getCurrentuser() {
        return currentuser;
    }

    public void setCurrentuser(User currentuser) {
        this.currentuser = currentuser;
    }
    public void print(ArrayList<User> c){
        for (User u:c ) {
            System.out.println(u.getOldCars());
        }
    }
}
