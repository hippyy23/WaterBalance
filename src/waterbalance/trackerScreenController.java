package waterbalance;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import ring.FillProgressIndicator;
import ring.RingProgressIndicator;

public class trackerScreenController implements Initializable{

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
    private Button addWaterButton;

    @FXML
    private Button setWaterButton;

    @FXML
    private Button okAddButton;

    @FXML
    private Button cancelAddButton;

    @FXML
    private Button okSetButton;

    @FXML
    private Button cancelSetButton;

    @FXML
    private TextField textFieldSet;

    @FXML
    private TextField textFieldAdd;

    @FXML
    void addWaterButton(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent add = FXMLLoader.load(getClass().getResource("littleWindowAdd.fxml"));
        Scene scene = new Scene(add, 250, 150);
        stage.setTitle("Drink Water");
        stage.getIcons().add(new Image("file:icons.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void exitButton(ActionEvent event) {
        WaterBalance.screenController.activate("loginScreen");
    }

    @FXML
    void setWaterButton(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent set = FXMLLoader.load(getClass().getResource("littleWindowSet.fxml"));
        Scene scene = new Scene(set, 250, 150);
        stage.setTitle("Daily Goal");
        stage.getIcons().add(new Image("file:icons.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();        
    }

    @FXML
    void statisticsButton(ActionEvent event) {

    }

    @FXML
    void trackerButton(ActionEvent event) {

    }

    @FXML
    void cancelAddButton(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void okAddButton(ActionEvent event) {
        System.out.println(textFieldAdd.getText());
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void calcelSetButton(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void okSetButton(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert trackerButton != null : "fx:id=\"trackerButton\" was not injected: check your FXML file 'trackerScreen.fxml'.";
        assert statisticsButton != null : "fx:id=\"statisticsButton\" was not injected: check your FXML file 'trackerScreen.fxml'.";
        assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'trackerScreen.fxml'.";
        assert stackPane != null : "fx:id=\"stackPane\" was not injected: check your FXML file 'trackerScreen.fxml'.";
        assert addWaterButton != null : "fx:id=\"addWaterButton\" was not injected: check your FXML file 'trackerScreen.fxml'.";
        assert setWaterButton != null : "fx:id=\"setWaterButton\" was not injected: check your FXML file 'trackerScreen.fxml'.";
        assert okAddButton != null : "fx:id=\"okAddButton\" was not injected: check your FXML file 'littleWindowAdd.fxml'.";
        assert cancelAddButton != null : "fx:id=\"cancelAddButton\" was not injected: check your FXML file 'littleWindowAdd.fxml'.";
        assert okSetButton != null : "fx:id=\"okSetButton\" was not injected: check your FXML file 'littleWindowSet.fxml'.";
        assert cancelSetButton != null : "fx:id=\"cancelSetButton\" was not injected: check your FXML file 'littleWindowSet.fxml'.";
        assert textFieldSet != null : "fx:id=\"textFieldSet\" was not injected: check your FXML file 'littleWindowSet.fxml'.";
        assert textFieldAdd != null : "fx:id=\"textFieldAdd\" was not injected: check your FXML file 'littleWindowSet.fxml'.";
       
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RingProgressIndicator ringProgressIndicator = new RingProgressIndicator();
        FillProgressIndicator ProgressIndicator = new FillProgressIndicator();
        ringProgressIndicator.setRingWidth(100);
        ProgressIndicator.setProgress(50);

        //stackPane.getChildren().add(ProgressIndicator);
    }
}
