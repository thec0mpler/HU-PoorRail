package org.hu.richrail.fxmlController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hu.richrail.model.TrainManager;

import java.io.IOException;


public abstract class Controller {
    protected TrainManager trainManager = TrainManager.getInstance();
    private Window parentWindow;
    private String title;
    private String resource;

    Controller() {
    }

    public Controller(Window parentWindow, String title, String resource) {
        this.parentWindow = parentWindow;
        this.title = title;
        this.resource = resource;

        init();
    }

    private void init() {
        try {
            Parent root = this.getRoot();

            this.getStage(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Parent getRoot() throws IOException {
        return FXMLLoader.load(getClass().getResource(this.resource));
    }

    private Stage getStage(Parent root) {
        Stage stage = new Stage();

        stage.setTitle(this.title);
        stage.setScene(new Scene(root));
        stage.setResizable(false);

        if (null != parentWindow) {
            stage.initOwner(parentWindow);
        }

        return stage;
    }
}
