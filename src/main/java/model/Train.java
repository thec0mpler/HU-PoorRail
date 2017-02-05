package model;

import java.util.List;

public class Train {
    private String name;
    private List<Vehicle> vehicles;

    public Train(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {   //Wrm kan ik dit niet aanroepen bij main?? [farshid]
        this.vehicles.add(vehicle);}


    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }

    public String toString() {
        return this.getName();

}

        }
