package waterbalance;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class trackerScreenController implements Initializable {

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
    private Button addWaterButton;

    @FXML
    private Label progreeLabel;

    @FXML
    private Button setWaterButton;

    @FXML
    private Pane paine;

    @FXML
    private Label notifyTracker;

    // ------------------------------METHODS-----------------------------------
    @FXML
    void addWaterButton(ActionEvent event) throws IOException {
        if (WaterBalance.entryContainer.getWaterGoal(WaterBalance.userCurrent) != 0) {
            WaterBalance.screenController.activate("addWater");
        } else {
            notifyTracker.setText("Daily goal!");
            WaterBalance.timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
                notifyTracker.setText("");
            })
            );
            WaterBalance.timeline.play();
        }
    }

    @FXML
    void exitButton(ActionEvent event) {
        WaterBalance.screenController.activate("loginScreen");
        WaterBalance.progressIndicator.setProgress(0);
    }

    @FXML
    void setWaterButton(ActionEvent event) throws IOException {
        if (WaterBalance.entryContainer.getWaterGoal(WaterBalance.userCurrent) == 0) {
            WaterBalance.screenController.activate("setWater");
        } else {
            notifyTracker.setText("Already set!");
            WaterBalance.timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
                notifyTracker.setText("");
            })
            );
            WaterBalance.timeline.play();
        }

    }

    @FXML
    void statisticsButton(ActionEvent event) {
        WaterBalance.screenController.activate("statisticsScreen");
    }

    @FXML
    void trackerButton(ActionEvent event) {
        progreeLabel.setText(WaterBalance.entryContainer.getCurrenWater(WaterBalance.userCurrent) + "/" + WaterBalance.entryContainer.getWaterGoal(WaterBalance.userCurrent) + " ml");
    }

    public static void increaseProgress() {
        int progress = WaterBalance.entryContainer.getCurrenWater(WaterBalance.userCurrent) * 100 / WaterBalance.entryContainer.getWaterGoal(WaterBalance.userCurrent);
        WaterBalance.progressIndicator.setProgress(progress);
    }

    public static void getUserProgress() {
        if (WaterBalance.entryContainer.getCurrenWater(WaterBalance.userCurrent) != 0
                && WaterBalance.entryContainer.getWaterGoal(WaterBalance.userCurrent) != 0) {
            int progress = WaterBalance.entryContainer.getCurrenWater(WaterBalance.userCurrent) * 100 / WaterBalance.entryContainer.getWaterGoal(WaterBalance.userCurrent);
            WaterBalance.progressIndicator.setProgress(progress);
        }

    }

    @FXML
    void initialize() {
        assert trackerButton != null : "fx:id=\"trackerButton\" was not injected: check your FXML file 'trackerScreen.fxml'.";
        assert statisticsButton != null : "fx:id=\"statisticsButton\" was not injected: check your FXML file 'trackerScreen.fxml'.";
        assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'trackerScreen.fxml'.";
        assert addWaterButton != null : "fx:id=\"addWaterButton\" was not injected: check your FXML file 'trackerScreen.fxml'.";
        assert setWaterButton != null : "fx:id=\"setWaterButton\" was not injected: check your FXML file 'trackerScreen.fxml'.";
        assert progreeLabel != null : "fx:id=\"setWaterButton\" was not injected: check your FXML file 'trackerScreen.fxml'.";
        assert notifyTracker != null : "fx:id=\"notifyTracker\" was not injected: check your FXML file 'trackerScreen.fxml'.";

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paine.getChildren().add(WaterBalance.progressIndicator);
        progreeLabel.setText("");
    }
}
