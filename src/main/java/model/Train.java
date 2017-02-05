package model;

import java.util.List;
import java.util.Observable;

public class Train extends Observable {
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

        changed();
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);

        changed();
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);

        changed();
    }

    public String toString() {
        return this.getName();
    }

    public void changed() {
        setChanged();
        notifyObservers();
    }
}
