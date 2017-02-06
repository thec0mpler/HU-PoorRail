package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Train extends Observable {
    private String name;
    private List<Vehicle> vehicles = new ArrayList<>();

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

    public boolean addVehicle(Vehicle vehicle) {
        if (!this.vehicles.contains(vehicle)) {
            this.vehicles.add(vehicle);

            return true;
        }

        changed();

        return false;
    }

    public int getSeats() {
        int seats = 0;
        for (Vehicle vehicle : vehicles) {
            seats += vehicle.getSeats();
        }

        return seats;
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);

        changed();
    }

    public boolean equals(Object object) {
        if (object instanceof Train) {
            Train train = (Train) object;

            if (this.getName().equals(train.getName())) {
                return true;
            }
        }

        return false;
    }

    public String toString() {
        return this.getName();
    }

    public void changed() {
        setChanged();
        notifyObservers();
    }
}
