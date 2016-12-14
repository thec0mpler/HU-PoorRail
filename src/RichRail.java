import model.Train;

import java.util.ArrayList;
import java.util.List;

public class RichRail{
    private List<Train> trains;

    public RichRail() {
        this.trains =  new ArrayList<>();
    }

    public void addTrain(Train train) {
        this.trains.add(train);
    }

    public void removeTrain(Train train) {
        this.trains.remove(train);
    }
}
