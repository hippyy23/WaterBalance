package waterbalance;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class loginScreenController {

    // ---------------------------ELEMENTS-------------------------------------
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane paneLogin;

    @FXML
    private Button loginButton;

    @FXML
    private TextField usernameArea;

    @FXML
    private Label labelLogo;

    @FXML
    private Label phrasesText;

    // ------------------------------METHODS-----------------------------------
    @FXML
    void loginButton(ActionEvent event) {

        if (!usernameArea.getText().isEmpty()) {
            WaterBalance.userContainer.addUser(usernameArea.getText());
            WaterBalance.userCurrent = WaterBalance.userContainer.getCurrentUser(usernameArea.getText());

            // set entryContainer -------------------------------------------------
            if (!WaterBalance.entryContainer.userExists(WaterBalance.userCurrent)) {
                WaterBalance.entryContainer.setNewUser(WaterBalance.userCurrent);
                WaterBalance.dayContainer.setNewUser(WaterBalance.userCurrent);
            }
            usernameArea.setText("");
            trackerScreenController.getUserProgress();
            WaterBalance.screenController.activate("trackerScreen");
        }
    }

    @FXML
    void initialize() throws IOException {
        assert paneLogin != null : "fx:id=\"paneLogin\" was not "
                + "injected: check your FXML file 'loginScreen.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not "
                + "injected: check your FXML file 'loginScreen.fxml'.";
        assert usernameArea != null : "fx:id=\"usernameArea\" was not "
                + "injected: check your FXML file 'loginScreen.fxml'.";
        assert labelLogo != null : "fx:id=\"labelLogo\" was not "
                + "injected: check your FXML file 'loginScreen.fxml'.";
        phrasesText.setText(WaterBalance.phrase[WaterBalance.indexPhrase]);

        try {
            WaterBalance.entryContainer.deserializeEntry();
            WaterBalance.userContainer.deserializeUser();
            WaterBalance.dayContainer.deserializeDay();
        } catch (FileNotFoundException ex) {
        }

    }
}
