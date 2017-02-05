package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class RichRail extends Observable { // Wat doet Observalbe? [farshid]
    private static RichRail richRail = new RichRail();
    private List<Train> trains;

    private RichRail() {
        this.trains = new ArrayList<>();
    }

    public static RichRail getInstance() {
        return richRail;
    } // Singleton? [moeten patterns benoemen]

    public List<Train> getTrains() {
        return this.trains;
    }

    public void addTrain(Train train) {
        this.trains.add(train);

        changed();
    }

    public void removeTrain(Train train) {
        this.trains.remove(train);

        changed();
    }

    public void changed() {
        setChanged();
        notifyObservers();
    }
}
