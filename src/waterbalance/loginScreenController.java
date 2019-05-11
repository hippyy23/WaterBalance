package waterbalance;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class loginScreenController {
    
    // class variables
    private int index;
    private String[] phrase;
    static String username;

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
    

    @FXML
    void loginButton(ActionEvent event) {
        username = usernameArea.getText();
        WaterBalance.screenController.activate("trackerScreen");
    }

    @FXML
    void initialize() {
        phrase = new String[5];
        phrase[0] = "Thousands have lived without love,\nnot one without water.";
        phrase[1] = "Keep calm\nDrink water";
        phrase[2] = "Water is your best friend for life.";
        phrase[3] = "Pure water is the world’s first and foremost medicine.";
        phrase[4] = "Make water your primary drink instead of soda.\nChoose pure water throughout your day.";
        index = (int) (Math.random() * 5);
        assert paneLogin != null : "fx:id=\"paneLogin\" was not injected: check your FXML file 'loginScreen.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'loginScreen.fxml'.";
        assert usernameArea != null : "fx:id=\"usernameArea\" was not injected: check your FXML file 'loginScreen.fxml'.";
        assert labelLogo != null : "fx:id=\"labelLogo\" was not injected: check your FXML file 'loginScreen.fxml'.";
        phrasesText.setText(phrase[4]);
    }
}
