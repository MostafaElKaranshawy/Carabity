package com.example.Carabity.carabity.service;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;


@JsonTypeName("car")
public class Car {

    @JsonProperty("rate")

    private int rate ;
    @JsonProperty("numberOfVoters")
    private int numberOfVoters ;
    @JsonProperty("id")
    private String id;
    @JsonProperty("Photo")
    private String photo;
    @JsonProperty("Price")
    private int price;
    @JsonProperty("Brand")
    private String brand;

    @JsonProperty("Model")
    private String model;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("AdType")
    private String adType;

    @JsonProperty("Fuel")
    private String fuel;

    @JsonProperty("Transmission")
    private String transmission;

    @JsonProperty("State")
    private String state;

    @JsonProperty("Engine")
    private String engine;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Features")
    private List<String> features;

    @JsonProperty("Availability")
    private String Availability  ;

    public Car(){}

    public String getId() {
        return id;
    }

    public String getPhoto() {
        return photo;
    }

    public int getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getAdType() {
        return adType;
    }

    public String getFuel() {
        return fuel;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getState() {
        return state;
    }

    public String getEngine() {
        return engine;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setAdType(String adType) {
        this.adType = adType;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public String isAvailability() {
        return Availability;
    }

    public void setAvailability(String availability) {
        Availability = availability;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getNumberOfVoters() {
        return numberOfVoters;
    }

    public void setNumberOfVoters(int numberOfVoters) {
        this.numberOfVoters = numberOfVoters;
    }

    public String getAvailability() {
        return Availability;
    }
// Additional setters if needed
}