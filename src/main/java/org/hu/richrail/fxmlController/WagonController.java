package org.hu.richrail.fxmlController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hu.richrail.model.Wagon;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WagonController extends Controller implements Initializable {
    @FXML
    private Wagon wagon;

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

    void init(Window window, Wagon wagon) {
        System.out.println("init1");
        System.out.println(wagon);
        this.wagon = wagon;

        init(window);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("init2");

        nameTextField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER))
                submit();
        });

        seatsTextField.setOnKeyPressed(KeyEvent -> {
            if (KeyEvent.getCode().equals(KeyCode.ENTER))
                submit();
        });

        submitButton.setOnAction(event -> submit()
        );

        System.out.println(this.wagon);

        if (wagon != null) {
            System.out.println("test");
            System.out.println(wagon.getName());
            nameTextField.setText(wagon.getName());
            seatsTextField.setText(String.valueOf(wagon.getSeats()));
        }
    }

    private void submit() {
        // System.out.println(nameTextField.getText());
        // System.out.println(seatsTextField.getText());
        try {
            trainManager.addWagon(
                    new Wagon(nameTextField.getText())
            );
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
