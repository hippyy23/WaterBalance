package waterbalance;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

public class statisticsScreenController implements Initializable {

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
    private BarChart<?, ?> barChart;

    // ------------------------------METHODS-----------------------------------
    @FXML
    void exitButton(ActionEvent event) {
        WaterBalance.screenController.activate("loginScreen");
        WaterBalance.progressIndicator.setProgress(0);
    }

    @FXML
    void statisticsButton(ActionEvent event) {
        barChart.getData().clear();
        if (!WaterBalance.dayContainer.isEmpty()) {
            XYChart.Series s = null;
            for (Day d : DayContainer.dayArray) {
                if (d.getUser().equals(WaterBalance.userCurrent.getUsername())) {
                    s = new XYChart.Series<>();
                    s.getData().add(new XYChart.Data(d.getDate().toString(), WaterBalance.dayContainer.getWaterAchieved(WaterBalance.userCurrent, d.getDate())));
                    s.getData().add(new XYChart.Data("Goal", WaterBalance.dayContainer.getWaterGoal(WaterBalance.userCurrent, d.getDate())));
                }
            }

            barChart.getData().addAll(s);
        }
    }

    @FXML
    void trackerButton(ActionEvent event) {
        WaterBalance.screenController.activate("trackerScreen");
    }

    @FXML
    void initialize() {
        assert trackerButton != null : "fx:id=\"trackerButton\" was not injected: check your FXML file 'statisticsScreen.fxml'.";
        assert statisticsButton != null : "fx:id=\"statisticsButton\" was not injected: check your FXML file 'statisticsScreen.fxml'.";
        assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'statisticsScreen.fxml'.";
        assert barChart != null : "fx:id=\"barChart\" was not injected: check your FXML file 'statisticsScreen.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        barChart.getData().clear();
    }
}
