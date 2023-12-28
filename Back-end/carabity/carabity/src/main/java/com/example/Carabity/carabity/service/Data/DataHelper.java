package com.example.Carabity.carabity.service.Data;

import com.example.Carabity.carabity.service.User;

import java.io.IOException;

public class DataHelper {
    public DataHelper() throws IOException {}
     readAndWriteData d = readAndWriteData.getInstance() ;
    public  User getUserByEmail(String email){
        for(User u : d.getUsers()){
            if(u.getEmail().equals(email))
                return u ;
        }
        return null ;
    }
}
