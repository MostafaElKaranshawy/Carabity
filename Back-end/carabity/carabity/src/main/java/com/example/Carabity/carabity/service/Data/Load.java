package com.example.Carabity.carabity.service.Data;

import com.example.Carabity.carabity.service.Car;

import java.util.List;
public class Load {
    private List<Car> cars;
    public Load(){}

    public List<Car> getCars() {
        return this.cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}