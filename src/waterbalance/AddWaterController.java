package waterbalance;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class AddWaterController {

    // ---------------------------ELEMENTS-------------------------------------
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button trackerButton;

    @FXML
    private Button statisticsButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button okAddButton;

    @FXML
    private TextField textFieldAdd;

    @FXML
    private Button cancelAddButton;

    @FXML
    private Label notifyAdd;

    // ------------------------------METHODS-----------------------------------
    @FXML
    void cancelAddButton(ActionEvent event) {
        WaterBalance.screenController.activate("trackerScreen");
    }

    @FXML
    void exitButton(ActionEvent event) {
        WaterBalance.screenController.activate("loginScreen");
    }

    @FXML
    void okAddButton(ActionEvent event) throws IOException {
        int waterAddValue = 0;
        try {
            waterAddValue = Integer.parseInt(textFieldAdd.getText());
            if (waterAddValue <= 0) {
                // ----------------ADD DEFAULT VALUE---------------------------
                notifyAdd.setText("Error value: default set");
                WaterBalance.timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
                    notifyAdd.setText("");
                    textFieldAdd.setText("");
                    WaterBalance.screenController.activate("trackerScreen");
                })
                );
                WaterBalance.timeline.play();
                WaterBalance.entryContainer.setCurrentWater(WaterBalance.userCurrent, 250);
                WaterBalance.dayContainer.setWaterAchieved(WaterBalance.userCurrent, 250);
                trackerScreenController.increaseProgress();
                WaterBalance.userContainer.serializeUser();
                WaterBalance.entryContainer.serializeEntry();
                WaterBalance.dayContainer.serializeDay();
            } else {
                WaterBalance.entryContainer.setCurrentWater(WaterBalance.userCurrent, waterAddValue);
                WaterBalance.dayContainer.setWaterAchieved(WaterBalance.userCurrent, waterAddValue);
                textFieldAdd.setText("");
                trackerScreenController.increaseProgress();
                WaterBalance.userContainer.serializeUser();
                WaterBalance.entryContainer.serializeEntry();
                WaterBalance.dayContainer.serializeDay();
                WaterBalance.screenController.activate("trackerScreen");
            }
        } catch (NumberFormatException ex) {
            // ---------------------SHOW NOTIFY LABEL--------------------------
            notifyAdd.setText("Error value: default set");
            WaterBalance.timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
                notifyAdd.setText("");
                textFieldAdd.setText("");
                WaterBalance.screenController.activate("trackerScreen");
            })
            );
            WaterBalance.timeline.play();
            // ----------------------ADD DEFAULT VALUE-------------------------
            WaterBalance.entryContainer.setCurrentWater(WaterBalance.userCurrent, 250);
            WaterBalance.dayContainer.setWaterAchieved(WaterBalance.userCurrent, 250);
            trackerScreenController.increaseProgress();
            WaterBalance.userContainer.serializeUser();
            WaterBalance.entryContainer.serializeEntry();
            WaterBalance.dayContainer.serializeDay();
        }

    }

    @FXML
    void statisticsButton(ActionEvent event) {
        WaterBalance.screenController.activate("statisticsScreen");
    }

    @FXML
    void trackerButton(ActionEvent event) {
        WaterBalance.screenController.activate("trackerScreen");
    }

    @FXML
    void initialize() {
        assert trackerButton != null : "fx:id=\"trackerButton\" was not injected: check your FXML file 'addWater.fxml'.";
        assert statisticsButton != null : "fx:id=\"statisticsButton\" was not injected: check your FXML file 'addWater.fxml'.";
        assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'addWater.fxml'.";
        assert okAddButton != null : "fx:id=\"okAddButton\" was not injected: check your FXML file 'addWater.fxml'.";
        assert textFieldAdd != null : "fx:id=\"textFieldAdd\" was not injected: check your FXML file 'addWater.fxml'.";
        assert cancelAddButton != null : "fx:id=\"cancelAddButton\" was not injected: check your FXML file 'addWater.fxml'.";
        assert notifyAdd != null : "fx:id=\"notifyAdd\" was not injected: check your FXML file 'addWater.fxml'.";
    }
}
