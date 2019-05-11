package waterbalance;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class statisticsScreenController {

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
    private StackPane stackPane;

    @FXML
    void exitButton(ActionEvent event) {

    }

    @FXML
    void statisticsButton(ActionEvent event) {

    }

    @FXML
    void trackerButton(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert trackerButton != null : "fx:id=\"trackerButton\" was not injected: check your FXML file 'trackerScreen.fxml'.";
        assert statisticsButton != null : "fx:id=\"statisticsButton\" was not injected: check your FXML file 'trackerScreen.fxml'.";
        assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'trackerScreen.fxml'.";
        assert stackPane != null : "fx:id=\"stackPane\" was not injected: check your FXML file 'trackerScreen.fxml'.";
    }
}
