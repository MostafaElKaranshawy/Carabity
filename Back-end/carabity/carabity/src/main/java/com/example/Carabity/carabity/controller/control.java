package com.example.Carabity.carabity.controller;

import com.example.Carabity.carabity.service.Car;
import com.example.Carabity.carabity.service.CarsService;
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
import java.util.List;


@CrossOrigin("http://localhost:8080")
@RestController

@RequestMapping("/user")
public class control {

    @Autowired
    private userService u;
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
    @PostMapping("/addnew")
    public  ResponseEntity<String> newCAr(@RequestParam String car) throws IOException {
       try {
            System.out.println("arrive " + car);
            u.addNewcar(car);
            return ResponseEntity.ok(car+" added successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error!") ;
        }
    }
    @PostMapping("/addold")
    public  ResponseEntity<String> oldCar(@RequestParam String car) throws IOException {
        try {
            System.out.println("arrive " + car);
            u.addOldcar(car);
            return ResponseEntity.ok(car+" added successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error!") ;
        }
    }
    @PostMapping("/rent")
    public  ResponseEntity<String> rent(@RequestParam String car) throws IOException {
        try {
            System.out.println("arrive " + car);
            u.addrent(car);
            return ResponseEntity.ok(car+" added successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error!") ;
        }
    }
    @GetMapping("/getCarsInfo")
    public List<Car> getCarsInfo() {
        try {
            String path = "E:\\material\\2nd year\\1st semester\\HCI\\carabity\\Web\\Back-end\\manyCars.json";
            System.out.println("path : ");
            System.out.println(path);
            List<Car> cars = CarsService.loadFromJson(path);
            return cars;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/load")
    public ArrayList<User>load() throws IOException {
        return u.loadAll();
    }

    }

