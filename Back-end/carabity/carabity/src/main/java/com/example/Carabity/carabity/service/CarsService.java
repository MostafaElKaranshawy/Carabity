package com.example.Carabity.carabity.service;

import com.example.Carabity.carabity.service.Data.Load;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class CarsService {
    public CarsService(){}
    public static List<Car> loadFromJson() throws IOException {
        try {
            String path = "E:\\material\\2nd year\\1st semester\\HCI\\carabity\\Web\\Back-end\\manyCars.json";
            ObjectMapper mapper = new ObjectMapper();
            Load load = mapper.readValue(new File(path), Load.class);
            return load.getCars();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void saveFromjson(Load l) throws IOException {
        //System.out.println("loaaad1111");
        try {
            String path = "E:\\material\\2nd year\\1st semester\\HCI\\carabity\\Web\\Back-end\\manyCars.json";
            ObjectMapper mapper = new ObjectMapper();
           // System.out.println("loaaad");
            mapper.writeValue(new File(path), l);
           // System.out.println(l.getCars().get(2).isAvailability());
            return  ;
        }catch (IOException e){
            e.printStackTrace();
            return  ;
        }
    }
    public List<Car> changeAvailability (List<Car> cars , String id){
        for (Car c:cars) {
            if(c.getId().equals(id)){
                c.setAvailability("unavailable");
                return cars ;
            }
        }
        return null ;
    }



}