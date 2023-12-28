package com.example.Carabity.carabity.controller;

import com.example.Carabity.carabity.service.*;
import com.example.Carabity.carabity.service.Data.Load;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin("http://localhost:8080")
@RestController

@RequestMapping("/user")
public class control {

    @Autowired
    private userService u;
    private CarsService c ;
    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody User user) throws IOException {
       try {
           System.out.println("arrive");
           System.out.println(user.getEmail() + "   " + user.getUsername()  );
           user = u.signup(user);
           System.out.println(user.getStatus());
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
    public  ResponseEntity<List<Car>> newCAr(@RequestParam String car) throws IOException {
       try {
            System.out.println("arrive " + car);
            u.addNewcar(car);
           List<Car> cars = CarsService.loadFromJson();
           for (int i = 0 ; i <cars.size(); i ++) {
               if(cars.get(i).getId().equals(car)){
                   cars.get(i).setAvailability("unavailable");
                   break ;
               }
           }
           Load load = new Load() ;
           load.setCars(cars);
           CarsService.saveFromjson(load);
            return ResponseEntity.ok(cars);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null) ;
        }
    }
    @PostMapping("/addold")
    public  ResponseEntity<List<Car>> oldCar(@RequestParam String car) throws IOException {
        try {
            System.out.println("arrive " + car);
            u.addOldcar(car);
            List<Car> cars = CarsService.loadFromJson();
            for (int i = 0 ; i <cars.size(); i ++) {
                if(cars.get(i).getId().equals(car)){
                    cars.get(i).setAvailability("unavailable");
                    break ;
                }
            }
            Load load = new Load() ;
            load.setCars(cars);
            CarsService.saveFromjson(load);
            return ResponseEntity.ok(cars);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null) ;
        }
    }
    @PostMapping("/rent")
    public  ResponseEntity<List<Car>> rent(@RequestParam String car) throws IOException {
        try {
            System.out.println("arrive " + car);
            u.addrent(car);
            List<Car> cars = CarsService.loadFromJson();
        for (int i = 0 ; i <cars.size(); i ++) {
            if(cars.get(i).getId().equals(car)){
                cars.get(i).setAvailability("unavailable");
                break ;
            }
        }
        Load load = new Load() ;
        load.setCars(cars);
        CarsService.saveFromjson(load);
            return ResponseEntity.ok(cars);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null) ;
        }
    }
    @GetMapping("/getCarsInfo")
    public List<Car> getCarsInfo() {
        try {
            String path = "E:\\material\\2nd year\\1st semester\\HCI\\carabity\\Web\\Back-end\\manyCars.json";
            System.out.println("path : ");
            System.out.println(path);
            List<Car> cars = CarsService.loadFromJson();
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

