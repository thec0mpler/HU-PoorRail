package model;

import java.util.ArrayList;
import java.util.List;

public class RichRail {
    private static RichRail richRail = new RichRail();
    private List<Train> trains;

    private RichRail() {
        this.trains = new ArrayList<>();
        this.trains.add(new Train("Train 4"));
    }

    public static RichRail getInstance() {
        return richRail;
    }

    public List<Train> getTrains() {
        return this.trains;
    }

    public void addTrain(Train train) {
        this.trains.add(train);
    }

    public void removeTrain(Train train) {
        this.trains.remove(train);
    }
}
