package org.hu.richrail.model;

import java.util.ArrayList;
import java.util.List;

public class TrainManager {
    private static TrainManager instance = new TrainManager();
    private List<Train> trains = new ArrayList<>();
    private List<Wagon> wagons = new ArrayList<>();

    private TrainManager() {
    }

    public static TrainManager getInstance() {
        return instance;
    }
    public void addTrain(Train train) {
        trains.add(train);
    }
    public Train getTrainByName(String name) throws Exception {
        for (Train train: trains) {
            if(train.getName().equals(name))
                return train;
        }

        return null;
    }


}
