package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.userService;


class user_get { 
  private String email ;
  private String password ;
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
}
@SpringBootApplication
@CrossOrigin("http://localhost:8080")
@RestController
public class DemoApplication {
    public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
    }
    @Autowired
    private userService u;

    @GetMapping("/user")
    public List<User> getUsers() {
      return u.getUserlist();
    }

    @PostMapping("/getuser")
    public User getuser(@RequestBody user_get us){
      String email = us.getEmail();
      String password = us.getPassword();
      return u.get(email, password);
    }

    @PostMapping("/check")
    public boolean createuser(@RequestBody User user){
      return u.save(user);
    }  

    @PostMapping("/getCarsInfo")
    public List<Car> getCarsInfo(@RequestParam String path) {
        try {
            System.out.println("path : ");
            System.out.println(path);
            List<Car> cars = CarsService.loadFromJson(path);
            return cars;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
