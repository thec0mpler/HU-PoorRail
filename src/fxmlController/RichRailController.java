package fxmlController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import model.RichRail;
import model.Train;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RichRailController implements Initializable {
    private RichRail richRail = RichRail.getInstance();

    @FXML
    private ComboBox<Train> trainCombo;

    @FXML
    private Button newTrainButton;

    @FXML
    private Button openTerminalButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.setTrainCombo(richRail.getTrains());

        trainCombo.setOnAction(event ->
                System.out.println("Selected train: " + trainCombo.getSelectionModel().getSelectedItem())
        );

        newTrainButton.setOnAction(event ->
                new NewTrainController().init(
                        newTrainButton.getScene().getWindow()
                )
        );

        openTerminalButton.setOnAction(event ->
            new TerminalController().init(
                    openTerminalButton.getScene().getWindow()
            )
        );
    }

    private void setTrainCombo(List<Train> trains) {
        trainCombo.getItems().setAll(trains);
    }
}
