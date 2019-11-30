package waterbalance;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ring.FillProgressIndicator;

/**
 * JAVAFXML APPLICATION THAT REGISTER YOUR WATER CONSUMPTION AND TRACKS IT
 *
 * @author Munteanu Adrian
 * @version 0.1
 */
public class WaterBalance extends Application {

    // STATIC OBJECTS
    // ------------------------------Timeline----------------------------------
    static Timeline timeline;
    // ------------------------------Indicator---------------------------------
    static ScreenController screenController;
    static FillProgressIndicator progressIndicator;
    // ----------------------------Array Lists---------------------------------
    static UserContainer userContainer;
    static EntryContainer entryContainer;
    static DayContainer dayContainer;
    // ------------------------Array phrase and index--------------------------
    static int indexPhrase;
    static String[] phrase;
    // --------------------------Add water status------------------------------
    static boolean addStatus;

    // ---------------------------Static variables-----------------------------
    static User userCurrent;

    @Override
    public void start(Stage stage) throws Exception {
        // ----------------Initialize array and index phrase-------------------
        phrase = new String[5];
        phrase[0] = "Thousands have lived without love,\nnot "
                + "one without water.";
        phrase[1] = "Keep calm\nDrink water";
        phrase[2] = "Water is your best friend for life.";
        phrase[3] = "Pure water is the world’s first and foremost medicine.";
        phrase[4] = "Make water your primary drink instead of soda.\nChoose "
                + "pure water throughout your day.";
        indexPhrase = (int) (Math.random() * 5);

        // ----------------------Initialize Array Lists------------------------
        userContainer = new UserContainer();
        entryContainer = new EntryContainer();
        dayContainer = new DayContainer();

        // -----------------------Initialize ring------------------------------
        progressIndicator = new FillProgressIndicator();

        // -----------------------Parent & Scene-------------------------------
        Parent root = FXMLLoader.load(getClass().getResource("loginScreen"
                + ".fxml"));
        Scene scene = new Scene(root, 681, 410);

        // -------------------Set title of the program-------------------------
        stage.setTitle("Water Balance");

        // --------------------------Set icon----------------------------------
        stage.getIcons().add(new Image("file:icons.png"));

        // -------------------------Add screens--------------------------------
        screenController = new ScreenController(scene);
        screenController.addScreen("loginScreen",
                FXMLLoader.load(getClass().getResource("loginScreen.fxml")));
        screenController.addScreen("trackerScreen",
                FXMLLoader.load(getClass().getResource("trackerScreen.fxml")));
        screenController.addScreen("statisticsScreen",
                FXMLLoader.load(getClass().getResource("statistics"
                        + "Screen.fxml")));
        screenController.addScreen("addWater",
                FXMLLoader.load(getClass().getResource("addWater.fxml")));
        screenController.addScreen("setWater",
                FXMLLoader.load(getClass().getResource("setWater.fxml")));

        // ----------------------Set scene and show it-------------------------
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
