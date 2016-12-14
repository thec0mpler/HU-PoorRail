package fxmlController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import model.Train;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RichRailController implements Initializable {
    @FXML
    private ComboBox<Train> trainCombo;

    public RichRailController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        trainCombo.setOnAction(event -> {
            System.out.println("Selected train: " + trainCombo.getSelectionModel().getSelectedItem());
        });
    }

    public void setTrainCombo(List<Train> trains) {
        trainCombo.getItems().setAll(trains);
    }
}
