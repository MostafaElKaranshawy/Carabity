package com.example.demo; 
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CarsService {
    public static List<Car> loadFromJson(String path) throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Load load = mapper.readValue(new File(path), Load.class);
            return load.getCars();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
