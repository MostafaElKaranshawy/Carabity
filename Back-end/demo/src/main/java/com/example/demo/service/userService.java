package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.User;

@Service
public class userService {
    List<User> userlist = new ArrayList<User> (Arrays.asList(
        new User("MostafaKransh", "mostafa1", "mostafa@gmail.com", 20),
        new User("RafyHany", "rafyhany1", "rafy@gmail.com", 21),
        new User("YomnaYasser", "yomnayasser1", "yomna@gmail.com", 22)
    ));
    public List<User> getUserlist() {
        return userlist;
    }
    public User get(String email, String password) {
        for(User user : userlist){
            if(user.getEmail().equals(email) && user.getPassword().equals(password))return user;
        }
        return new User("none","none", "none", 0);
    }
    public boolean save(User user){
        return userlist.add(user);
    }
}
