import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static RichRail richRail;

    public static void main(String[] args) {
        richRail = new RichRail();

        launch(args);
    }

    public static RichRail getRichRail() {
        return richRail;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("RichRail.fxml"));

        primaryStage.setTitle("RichRail");
        primaryStage.setScene(new Scene(root, 400, 600));

        primaryStage.show();
    }
}
