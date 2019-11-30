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

public class SetWaterController {

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
    private Button okSetButton;

    @FXML
    private TextField textFieldSet;

    @FXML
    private Button cancelSetButton;

    @FXML
    private Label notifySet;

    // ------------------------------METHODS-----------------------------------
    @FXML
    void cancelSetButton(ActionEvent event) {
        WaterBalance.screenController.activate("trackerScreen");
    }

    @FXML
    void exitButton(ActionEvent event) {
        WaterBalance.screenController.activate("loginScreen");
    }

    @FXML
    void okSetButton(ActionEvent event) throws IOException {
        int waterGoal = 0;

        try {
            waterGoal = Integer.parseInt(textFieldSet.getText());
            if (waterGoal <= 0) {
                // -------------------ADD DEFAULT VALUE------------------------
                notifySet.setText("Error value: default set");
                WaterBalance.timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
                    notifySet.setText("");
                    textFieldSet.setText("");
                    WaterBalance.screenController.activate("trackerScreen");
                })
                );
                WaterBalance.timeline.play();
                WaterBalance.entryContainer.setWaterGoal(WaterBalance.userCurrent, 2500);
                WaterBalance.dayContainer.setWaterGoal(WaterBalance.userCurrent, 2500);
                WaterBalance.userContainer.serializeUser();
                WaterBalance.entryContainer.serializeEntry();
                WaterBalance.dayContainer.serializeDay();
            } else {
                // --------------------ADD INSERTED VALUE----------------------
                WaterBalance.entryContainer.setWaterGoal(WaterBalance.userCurrent, waterGoal);
                WaterBalance.dayContainer.setWaterGoal(WaterBalance.userCurrent, waterGoal);
                WaterBalance.userContainer.serializeUser();
                WaterBalance.entryContainer.serializeEntry();
                WaterBalance.dayContainer.serializeDay();
                textFieldSet.setText("");
                WaterBalance.screenController.activate("trackerScreen");
            }
        } catch (NumberFormatException ex) {
            // ---------------------SHOW WRONG LABEL---------------------------
            notifySet.setText("Error value: default set");
            WaterBalance.timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
                notifySet.setText("");
                textFieldSet.setText("");
                WaterBalance.screenController.activate("trackerScreen");
            })
            );
            WaterBalance.timeline.play();
            // -------------------ADD DEFAULT VALUE----------------------------
            WaterBalance.entryContainer.setWaterGoal(WaterBalance.userCurrent, 2500);
            WaterBalance.dayContainer.setWaterGoal(WaterBalance.userCurrent, 2500);
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
        assert trackerButton != null : "fx:id=\"trackerButton\" was not injected: check your FXML file 'setWater.fxml'.";
        assert statisticsButton != null : "fx:id=\"statisticsButton\" was not injected: check your FXML file 'setWater.fxml'.";
        assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'setWater.fxml'.";
        assert okSetButton != null : "fx:id=\"okSetButton\" was not injected: check your FXML file 'setWater.fxml'.";
        assert textFieldSet != null : "fx:id=\"textFieldSet\" was not injected: check your FXML file 'setWater.fxml'.";
        assert cancelSetButton != null : "fx:id=\"cancelSetButton\" was not injected: check your FXML file 'setWater.fxml'.";
        assert notifySet != null : "fx:id=\"notifySet\" was not injected: check your FXML file 'setWater.fxml'.";

    }
}
