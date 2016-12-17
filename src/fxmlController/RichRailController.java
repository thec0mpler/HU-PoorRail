package fxmlController;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import model.RichRail;
import model.Train;

import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class RichRailController implements Initializable, Observer {
    private RichRail richRail = RichRail.getInstance();

    @FXML
    private ComboBox<Train> trainCombo;

    @FXML
    private Button newTrainButton;

    @FXML
    private Button deleteTrainButton;

    @FXML
    private Button addWagonButton;

    @FXML
    private Button openTerminalButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        richRail.addObserver(this);

        trainCombo.setOnAction(event ->
                System.out.println("Selected train: " + trainCombo.getSelectionModel().getSelectedItem())
        );

        newTrainButton.setOnAction(event ->
                new NewTrainController().init(
                        newTrainButton.getScene().getWindow()
                )
        );

        deleteTrainButton.setOnAction(event -> deleteTrain());

        addWagonButton.setOnAction(event ->
                new WagonController().init(
                    addWagonButton.getScene().getWindow()
                )
        );

        openTerminalButton.setOnAction(event ->
                new TerminalController().init(
                    openTerminalButton.getScene().getWindow()
                )
        );
    }

    private void setTrainCombo() {
        trainCombo.getItems().setAll(
                richRail.getTrains()
        );
    }

    private void deleteTrain() {
        Train selectedTrain = trainCombo.getSelectionModel().getSelectedItem();
        richRail.removeTrain(selectedTrain);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof RichRail) {
            setTrainCombo();
            trainCombo.getSelectionModel().selectLast();
        }
    }
}
