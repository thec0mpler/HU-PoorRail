package model;

import model.vehicle.Wagon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

public class RichRail extends Observable {
    private static RichRail richRail = new RichRail();
    private List<Train> trains;

    private RichRail() {
        this.trains = new ArrayList<>();
    }

    public static RichRail getInstance() {
        return richRail;
    }

    public List<Train> getTrains() {
        return this.trains;
    }

    public boolean addTrain(Train train) {
        if (!trains.contains(train)) {
            this.trains.add(train);

            changed();

            return true;
        }

        return false;
    }

    public void removeTrain(Train train) {
        this.trains.remove(train);

        changed();
    }

    public Train getTrain(String name) {
        Train tempTrain = new Train(name);

        for (Train train : trains) {
            if (train.equals(tempTrain)) {
                return train;
            }
        }

        return null;
    }

    public Wagon getWagon(String name) {
        for (Train train : trains) {
            for (Vehicle vehicle : train.getVehicles()) {
                if (vehicle instanceof Wagon) {
                    Wagon wagon = (Wagon) vehicle;

                    if (wagon.getName().equals(name)) {
                        return wagon;
                    }
                }
            }
        }

        return null;
    }

    public void changed() {
        setChanged();
        notifyObservers();
    }
}
