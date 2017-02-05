import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Commands;
import model.Train;
import model.Vehicle;

import java.util.Scanner;

public class Main/* extends Application */{
    public static void main(String[] args) {
        Commands addCommand = Commands.ADD;
        Scanner input = new Scanner(System.in);
        String i = input.next().toUpperCase();    //String input = "add 3 to 5"; // We moeten ID gebruiken ipv variable namen

        //i.toUpperCase(); //miss niet meer nodig door 1 regel hierboven.

        if (eersteWord.equals(addCommand.name())) {  // name() maakt t String
            if (trainManager.zoekTrein(tweedeWord)) {
                Train train = trainManager.getTrainByID(tweedeWord);
                if (derdeWord.equals("TO")) {
                    train.add(vierdeWord);
                }
            } else {
                // error
            }
        }
        else {
            // error
        }
    }
    Train t = new Train("d");
    private String execute(String input) {
        return "The command nr. 1 is executed.";
    }
   /* @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("RichRail.fxml"));

        primaryStage.setTitle("RichRail");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);

        primaryStage.show();
    }*/
//   Train t = new Train("hmm");
//    t.addVehicle



}
