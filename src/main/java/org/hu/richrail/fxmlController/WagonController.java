package org.hu.richrail.fxmlController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hu.richrail.model.Train;
import org.hu.richrail.model.Wagon;

import java.net.URL;
import java.util.ResourceBundle;

public class WagonController extends Controller implements Initializable {
    private boolean isNew;
    private Wagon wagon;
    private Train train;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField seatsTextField;

    @FXML
    private Button submitButton ;

    void init(Window window, Wagon wagon, Train train) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Wagon.fxml"));

            Stage terminalStage = new Stage();
            terminalStage.setTitle("Wagon");
            terminalStage.setScene(new Scene(loader.load()));
            terminalStage.setResizable(false);
            terminalStage.initModality(Modality.APPLICATION_MODAL);

            WagonController wagonController = loader.getController();
            wagonController.setWagon(wagon);
            wagonController.setTrain(train);

            if (window != null)
                terminalStage.initOwner(window);

            terminalStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameTextField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER))
                submit();
        });

        seatsTextField.setOnKeyPressed(KeyEvent -> {
            if (KeyEvent.getCode().equals(KeyCode.ENTER))
                submit();
        });

        submitButton.setOnAction(event -> submit());
    }

    public void setWagon(Wagon wagon) {
        isNew = wagon == null;
        this.wagon = wagon;

        if (wagon != null) {
            nameTextField.setText(wagon.getName());
            seatsTextField.setText(String.valueOf(wagon.getSeats()));
        }
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    private void submit() {
        try {
            String name = nameTextField.getText();
            int seats = Integer.parseInt(seatsTextField.getText());

            if (isNew) {
                Wagon wagon = new Wagon(name, seats);
                wagon.setTrain(train);

                trainManager.addWagon(wagon);
            } else {
                wagon.setName(name);
                wagon.setSeats(seats);
            }

            trainManager.changed();
        } catch (Exception e) {
            e.printStackTrace();
        }

        close();
    }
    private void close() {
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.close();
    }

    @Override
    protected void show() {
    }
}
