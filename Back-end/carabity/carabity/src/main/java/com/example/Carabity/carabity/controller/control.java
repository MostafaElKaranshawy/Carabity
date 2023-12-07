package com.example.Carabity.carabity.controller;

import com.example.Carabity.carabity.service.User;
import com.example.Carabity.carabity.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;


@CrossOrigin("http://localhost:8080")
@RestController

@RequestMapping("/user")
public class control {

    @Autowired
    private userService u;
//    @GetMapping("/user")
//    public List<User> getUsers() {
//        return u.getUserlist();
//    }
//
//    @PostMapping("/getuser")
//    public User getuser(@RequestBody user_get us){
//        String email = us.getEmail();
//        String password = us.getPassword();
//        return u.get(email, password);
//    }
//
//    @PostMapping("/check")
//    public boolean createuser(@RequestBody User user){
//        return u.save(user);
//    }
    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody User user) throws IOException {
       try {
           System.out.println("arrive");

           user = u.signup(user);
           if(user.getStatus().equals("Successfully signed")) {
               System.out.println("sign up ");
               return ResponseEntity.ok(user);
           }else {
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(user)  ;
           }
       }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null) ;
       }
    }
    @PostMapping("/signin")
    public  ResponseEntity<User> signIn(@RequestBody User user){
        try {
            System.out.println("arrive");

            user = u.signin(user);
            if(user.getStatus().equals("Successfully signed")) {
                System.out.println("sign in ");
                return ResponseEntity.ok(user);
            }else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(user)  ;
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null) ;
        }
    }
    @PostMapping("/load")
    public ArrayList<User>load() throws IOException {
        return u.loadAll();
    }

    }

