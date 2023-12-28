package com.example.Carabity.carabity.service;

import com.example.Carabity.carabity.service.Data.DataHelper;
import com.example.Carabity.carabity.service.Data.readAndWriteData;
import com.example.Carabity.carabity.service.Encryption.EncryptionHashing;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@Service
public class userService {
    private readAndWriteData r = readAndWriteData.getInstance() ;
    private User currentuser ;
    public userService() throws IOException {
        r.loadToJson("E:\\material\\2nd year\\1st semester\\HCI\\carabity\\Web\\Back-end\\users.json");
    }
    public User signup(User user) throws IOException, NoSuchAlgorithmException {
        if (checkEmail(user)) {
            user.setStatus("This email is already exist!");
            return user;
        }
            System.out.println(user.getUsername());

            if (checkUsername(user)) {
                user.setStatus("This username is already exist!");
                return user;
            }
            if (!(user.getEmail().endsWith("@gmail.com") || user.getEmail().endsWith("@alexu.edu.eg"))) {
                user.setStatus("Invalid domain of email");
                return user;
            }
            if (user.getPassword().length() < 8) {
                user.setStatus("Password length must be at least 8");
                return user;
            }
            user.setStatus("Successfully signed");
            user.setPassword(EncryptionHashing.getSHA(user.getPassword()));
            r.add(user);
            this.currentuser = user;
            return user;
        }

        public User signin(User user) throws IOException, NoSuchAlgorithmException {
            if (!checkEmail(user)) {
                user.setStatus("This email is not exist");
                return user;
            }
            if (!checkPassword(user)) {
                user.setStatus("Invalid password");
                return user;
            }
                DataHelper data = new DataHelper();
                user = data.getUserByEmail(user.getEmail());
                user.setStatus("Successfully signed");
                this.currentuser = user;
                System.out.println(currentuser.getEmail());
                return user;
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

            public boolean checkPassword(User user) throws NoSuchAlgorithmException {
                String hashingPassword = EncryptionHashing.getSHA(user.getPassword());
                for (User u : r.getUsers()) {
                    if (u.getEmail().equals(user.getEmail()) && u.getPassword().equals(hashingPassword))
                        return true;
                }
                return false;
            }

                public boolean checkEmail(User user){
                    for (User u : r.getUsers()  ) {
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
