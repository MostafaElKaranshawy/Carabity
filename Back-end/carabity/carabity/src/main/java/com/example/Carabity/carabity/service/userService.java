package com.example.Carabity.carabity.service;

import com.example.Carabity.carabity.service.Data.DataHelper;
import com.example.Carabity.carabity.service.Data.Load;
import com.example.Carabity.carabity.service.Data.readAndWriteData;
import com.example.Carabity.carabity.service.Encryption.EncryptionHashing;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

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
    public ArrayList<String> makeFavorite(String car) throws IOException {
        DataHelper d = new DataHelper() ;
        User u = d.getUserByEmail(currentuser.getEmail()) ;
        if(u != null){
            if(!u.getFavorite().contains(car)){
                u.fav(car);

                r.saveToJson();
            }
            return u.getFavorite() ;
        }
        return null ;
    }
    public ArrayList<String> removeFromFavorite(String car) throws IOException {
        DataHelper d = new DataHelper() ;
        User u = d.getUserByEmail(currentuser.getEmail()) ;
        if(u != null){
            for(int i = 0 ; i < u.getFavorite().size() ; ++i){
                if(u.getFavorite().get(i).equals(car)){
                    u.getFavorite().remove(i) ;

                    r.saveToJson();
                    return u.getFavorite() ;
                }
            }
            return u.getFavorite() ;
        }

        return null ;
    }
    public float rateCar(String car , int rate) throws IOException {
        List<Car> cars = CarsService.loadFromJson();
        DataHelper d = new DataHelper() ;
        User u =  d.getUserByEmail(currentuser.getEmail()) ;
        float newRate = 0 ;
            for (int i = 0 ; i <cars.size(); i ++) {
                if (cars.get(i).getId().equals(car)) {
                    if (u.getRating().containsKey(car)) {
                        newRate = cars.get(i).getRate() * cars.get(i).getNumberOfVoters() - u.getRating().get(car) ;
                        newRate = ( newRate + rate ) / cars.get(i).getNumberOfVoters() ;
                        cars.get(i).setRate(newRate);
                        u.getRating().put(car , rate) ;
                    }else {
                        newRate = cars.get(i).getRate() * cars.get(i).getNumberOfVoters() ;
                        cars.get(i).setNumberOfVoters(cars.get(i).getNumberOfVoters() + 1 );
                        newRate = ( newRate + rate ) / cars.get(i).getNumberOfVoters() ;
                        cars.get(i).setRate(newRate);
                        u.getRating().put(car , rate) ;
                    }
                }
            }
        Load load = new Load() ;
        load.setCars(cars);
        CarsService.saveFromjson(load);
        r.saveToJson();
        currentuser = u ;
        return newRate ;

    }


    public boolean checkPassword(User user) throws NoSuchAlgorithmException {
        String hashingPassword = EncryptionHashing.getSHA(user.getPassword());
        for (User u : r.getUsers()) {
            if (u.getEmail().equals(user.getEmail()) && u.getPassword().equals(hashingPassword))
                return true;
        }
        return false;
    }
    public boolean checkPassword(String email , String password) throws NoSuchAlgorithmException {
        String hashingPassword = EncryptionHashing.getSHA(password);
        for (User u : r.getUsers()) {
            if (u.getEmail().equals(email) && u.getPassword().equals(hashingPassword))
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
    public boolean checkUsername(String user){
        for (User u: r.getUsers()  ) {
            if(u.getUsername().equals(user))
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
    public User changePassword(String oldPass , String newPass) throws NoSuchAlgorithmException, IOException {
        DataHelper d = new DataHelper() ;
        User u = d.getUserByEmail(currentuser.getEmail()) ;
        if(!checkPassword(u.getEmail() , oldPass)){
            User u2 = new User() ;
            u2.setStatus("Old password is not correct");
            return u2 ;
        }
        if(newPass.length() < 8){
            User u2 = new User() ;
            u2.setStatus("New password length must be at least 8");
            return u2 ;

        }
        u.setStatus("Password changed successfully");
        u.setPassword(EncryptionHashing.getSHA(newPass)) ;
        r.saveToJson();
        return u ;
    }
    public User changeUserName(String newUserName) throws IOException {
        DataHelper d = new DataHelper();
        User u = d.getUserByEmail(currentuser.getEmail()) ;
        if(checkUsername(newUserName)){
            User u2 = new User() ;
            u2.setStatus("User name has already exist");
            return u2 ;
        }
        u.setUsername(newUserName);
        currentuser.setUsername(newUserName);
        u.setStatus("UserName changed successfully");
        r.saveToJson();
        return u ;
    }
    public User changeCover(ProfilePicture cover) throws IOException {
        DataHelper d = new DataHelper();
        User u = d.getUserByEmail(currentuser.getEmail()) ;
        u.setCover(cover);
        currentuser.setCover(cover);
        r.saveToJson();
        return u ;
    }




}
