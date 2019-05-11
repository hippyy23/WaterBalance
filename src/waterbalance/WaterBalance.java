package waterbalance;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Adrian
 */
public class WaterBalance extends Application {

    static ScreenController screenController;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));

        Scene scene = new Scene(root, 681, 410);

        // set title of the program
        stage.setTitle("Water Balance");

        // set icon
        stage.getIcons().add(new Image("file:icons.png"));

        // add screens
        screenController = new ScreenController(scene);
        screenController.addScreen("loginScreen", FXMLLoader.load(getClass().getResource("loginScreen.fxml")));
        screenController.addScreen("statisticsScreen", FXMLLoader.load(getClass().getResource("statisticsScreen.fxml")));
        screenController.addScreen("trackerScreen", FXMLLoader.load(getClass().getResource("trackerScreen.fxml")));

        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
