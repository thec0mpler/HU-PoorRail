package org.hu.richrail.fxmlController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import org.hu.richrail.model.Train;
import org.hu.richrail.model.TrainManager;
import org.hu.richrail.model.Wagon;

import java.net.URL;
import java.util.*;

public class RichRailController extends Controller implements Initializable, Observer {
    @FXML
    private ComboBox<Train> trainCombo;

    @FXML
    private Button newTrainButton;

    @FXML
    private TextField trainNameTextField;

    @FXML
    private Button deleteTrainButton;

    @FXML
    private VBox wagonBox;

    @FXML
    private Button addWagonButton;

    @FXML
    private Button editWagon;

    @FXML
    private ComboBox<Wagon> wagonCombo;

    @FXML
    private Button deleteWagonButton;

    @FXML
    private TextField wagonNameTextField;

    @FXML
    private Button openTerminalButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        trainManager.addObserver(this);

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

        deleteWagonButton.setOnAction(event -> deleteWagon());

        openTerminalButton.setOnAction(event ->
                new TerminalController().init(
                        openTerminalButton.getScene().getWindow()
                )
        );

        addWagonButton.setOnAction(event ->
                new WagonController().init(
                        addWagonButton.getScene().getWindow(),
                        null,
                        getSelectedTrain()
                )
        );

        editWagon.setOnAction(event ->
                new WagonController().init(
                        editWagon.getScene().getWindow(),
                        getSelectedWagon(),
                        getSelectedTrain()
                )
        );

        wagonNameTextField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                setWagonName(wagonNameTextField.getText());
            }
        });

        wagonCombo.setOnAction(event ->
                selectWagon(wagonCombo.getSelectionModel().getSelectedItem())
        );
    }

    private Wagon getSelectedWagon() {
        return wagonCombo.getSelectionModel().getSelectedItem();
    }

    private void selectWagon(Wagon wagon) {
        System.out.println("Selected wagon: " + wagon);

        String wagonName = "";
        if (wagon != null) {
            wagonName = wagon.getName();
        }

        wagonCombo.getSelectionModel().select(wagon);
        wagonNameTextField.setText(wagonName);
        editWagon.setDisable(wagon == null);
    }

    private void setWagonCombo() {
        System.out.println("setWagonCombo");

        wagonCombo.getItems().setAll(
                trainManager.getWagonsByTrain(getSelectedTrain())
        );
    }
    private void setWagonName(String name) {
        System.out.println("setWagonName: " + name);

        if (getSelectedWagon() != null) {
            try {
                getSelectedWagon().setName(name);
            } catch (Exception e) {
                e.printStackTrace();
            }

            trainManager.changed();
        }
    }
    private void deleteWagon(){
        if(getSelectedWagon() != null){
            trainManager.removeWagon(getSelectedWagon());
        }
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

        wagonBox.setDisable(train == null);

        wagonCombo.getSelectionModel().clearSelection();
        setWagonCombo();
    }

    private void setTrainCombo() {
        System.out.println("setTrainCombo");

        trainCombo.getItems().setAll(
                trainManager.getTrains()
        );
    }

    private void setTrainName(String name) {
        System.out.println("setTrainName: " + name);

        if (getSelectedTrain() != null) {
            try {
                getSelectedTrain().setName(name);
            } catch (Exception e) {
                e.printStackTrace();
            }

            trainManager.changed();
        }
    }

    private void deleteTrain() {
        if (getSelectedTrain() != null)
            trainManager.removeTrain(getSelectedTrain());
    }

    @Override
    public void update(Observable o, Object arg) {
        Train selectedTrain = getSelectedTrain();
        Wagon selectedWagon = getSelectedWagon();

        if (o instanceof TrainManager) {
            setTrainCombo();
            setWagonCombo();
        }

        if (trainManager.getTrains().contains(selectedTrain))
            selectTrain(selectedTrain);

        if(trainManager.getWagons().contains(selectedWagon))
            selectWagon(selectedWagon);
        else
            selectWagon(null);
    }
}
