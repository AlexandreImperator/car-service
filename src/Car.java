package com.example.devsecops;

public class Car {
    private String plateNumber;
    private String brand;
    private int price;
    private boolean rented;
    private Dates rentalDates;
    
    public Car(String plateNumber, String brand, int price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        this.rented = false;
        this.rentalDates = null;
    }

    public String getPlateNumber() { return plateNumber; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public boolean isRented() { return rented; }
    public void setRented(boolean rented) { this.rented = rented; }

    public Dates getDates() { return rentalDates; }
    public void setDates(Dates dates) { this.rentalDates = dates; }
}
