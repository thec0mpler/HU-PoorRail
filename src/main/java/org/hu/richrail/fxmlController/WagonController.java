package org.hu.richrail.fxmlController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WagonController implements Initializable {
    @FXML
    private TextField nameTextField;

    @FXML
    private TextField seatsTextField;

    @FXML
    private Button submitButton ;

    void init(Window window) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Wagon.fxml"));
            Stage terminalStage = new Stage();

            terminalStage.setTitle("Wagon");
            terminalStage.setScene(new Scene(root));
            terminalStage.setResizable(false);
            terminalStage.initModality(Modality.APPLICATION_MODAL);

            if (window != null)
                terminalStage.initOwner(window);

            terminalStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        submitButton.setOnAction(event -> submit());
    }

    private void submit() {
        // System.out.println(nameTextField.getText());
        // System.out.println(seatsTextField.getText());

        close();
    }

    private void close() {
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.close();
    }
}
