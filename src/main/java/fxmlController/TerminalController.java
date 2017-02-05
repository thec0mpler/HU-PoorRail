package fxmlController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TerminalController implements Initializable {
    @FXML
    private Button closeButton;

    void init(Window window) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Terminal.fxml"));
            Stage terminalStage = new Stage();

            terminalStage.setTitle("Terminal");
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
        closeButton.setOnAction(event -> this.close());
    }

    private void close() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
