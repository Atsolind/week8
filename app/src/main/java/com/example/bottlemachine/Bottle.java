package com.example.bottlemachine;

public class Bottle {
    private String name;
    private String manufacturer;
    private double total_energy;
    private double cost;
    private double size;
    @Override
            public String toString(){
        return manufacturer+" "+name+" "+size+"l "+total_energy+"cal "+cost+"€";
    }

    Bottle(String name, String manufacturer, double total_energy, double cost, double size){
        this.name = name;
        this.manufacturer = manufacturer;
        this.total_energy = total_energy;
        this.cost = cost;
        this.size = size;
    }

    String getName(){
        return name;
    }
    public String getManufacturer(){
        return manufacturer;
    }
    public double getEnergy(){
        return total_energy;
    }
    double getCost() {
        return cost;
    }
    double getSize() {
        return size;
    }
}
