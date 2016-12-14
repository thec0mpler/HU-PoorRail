import model.Train;

import java.util.ArrayList;
import java.util.List;

public class RichRail {
    private List<Train> trains;

    public RichRail() {
        this.trains =  new ArrayList<>();
        this.trains.add(new Train("Train 1"));
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
