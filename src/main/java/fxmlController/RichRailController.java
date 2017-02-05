package fxmlController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import model.RichRail;
import model.Train;

import java.net.URL;
import java.util.*;

public class RichRailController implements Initializable, Observer {
    private RichRail richRail = RichRail.getInstance();

    @FXML
    private ComboBox<Train> trainCombo;

    @FXML
    private Button newTrainButton;

    @FXML
    private TextField trainNameTextField;

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
                selectTrain(trainCombo.getSelectionModel().getSelectedItem())
        );

        newTrainButton.setOnAction(event ->
                new NewTrainController().init(
                        newTrainButton.getScene().getWindow()
                )
        );

        trainNameTextField.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                    setTrainName(trainNameTextField.getText());
                }
        });

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

    private Train getSelectedTrain() {
        return trainCombo.getSelectionModel().getSelectedItem();
    }

    private void selectTrain(Train train) {
        System.out.println("Selected train: " + train);

        String trainName = "";
        if (train != null) {
            trainName = train.getName();
        }

        trainCombo.getSelectionModel().select(train);
        trainNameTextField.setText(trainName);
    }

    private void setTrainCombo() {
        System.out.println("setTrainCombo");

        trainCombo.getItems().setAll(
                richRail.getTrains()
        );
    }

    private void setTrainName(String name) {
        System.out.println("setTrainName: " + name);

        if (getSelectedTrain() != null) {
            getSelectedTrain().setName(name);

            richRail.changed();
        }
    }

    private void deleteTrain() {
        if (getSelectedTrain() != null)
            richRail.removeTrain(getSelectedTrain());
    }

    @Override
    public void update(Observable o, Object arg) {
        Train selectedTrain = getSelectedTrain();

        if (o instanceof RichRail)
            setTrainCombo();

        if (richRail.getTrains().contains(selectedTrain))
            selectTrain(selectedTrain);
        else
            selectTrain(null);
    }
}
