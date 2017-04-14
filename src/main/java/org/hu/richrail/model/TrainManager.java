package org.hu.richrail.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class TrainManager extends Observable {
    private static TrainManager instance = new TrainManager();
    private List<Train> trains = new ArrayList<>();
    private List<Wagon> wagons = new ArrayList<>();

    private TrainManager() {
    }

    public static TrainManager getInstance() {
        return instance;
    }

//    public void editTrain()
//        if()

    public boolean addTrain(Train train) {
        if (!trains.contains(train)) {
            trains.add(train);

            changed();

            return true;
        }

        return false;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public Train getTrainByName(String name) {
        for (Train train : trains) {
            if (train.getName().equals(name))
                return train;
        }

        return null;
    }

    public void removeTrain(Train train) {
        trains.remove(train);

        changed();
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public boolean addWagon(Wagon wagon) {
        if (!wagons.contains(wagon)) {
            wagons.add(wagon);

        changed();

        return true;
    }
    return false;
}

    public Wagon getWagonByName(String name) {
        for (Wagon wagon: wagons) {
            if (wagon.getName().equals(name))
                return wagon;
        }

        return null;
    }

    public void removeWagon(Wagon wagon) {
        wagons.remove(wagon);

        changed();
    }

    public void changed() {
        setChanged();
        notifyObservers();
    }
}
