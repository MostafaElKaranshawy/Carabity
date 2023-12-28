package com.example.Carabity.carabity.service.Data;

import com.example.Carabity.carabity.service.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class readAndWriteData {
    private static readAndWriteData data = null ;
    private static ArrayList<User> users = new ArrayList<User>();
    private readAndWriteData () throws IOException {
    }


    public void add(User user) throws IOException {
        users.add(user) ;
        saveToJson();

        return;
    }
    public ArrayList<User> getUsers() {
        return users;
    }

    public  void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public static readAndWriteData getInstance() throws IOException {
        if(data==null)
            return new readAndWriteData() ;
        return data ;
    }
    public void saveToJson() throws IOException {
        try {
            String path = "E:\\material\\2nd year\\1st semester\\HCI\\carabity\\Web\\Back-end\\users.json";
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(path), this);
            loadToJson(path);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public ArrayList<User> loadToJson(String path) throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            readAndWriteData users = mapper.readValue(new File(path), readAndWriteData.class);
            setUsers(users.getUsers());
            return users.getUsers();
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }

    }

}
