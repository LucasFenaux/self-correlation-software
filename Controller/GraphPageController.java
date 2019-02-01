package Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.MissingFormatArgumentException;
import java.util.ResourceBundle;
import java.lang.Number;

import Model.SCS;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class GraphPageController {

    @FXML
    private Button exitDone;

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;


    public GraphPageController(){

    }

    @FXML
    private void initialize(){

    }

    @FXML
    private void buttonPushed() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/MainPage.fxml"));
        Stage stage = (Stage) exitDone.getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);


    }
}
