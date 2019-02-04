package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        FXMLLoader loader = new FXMLLoader(GraphPageController.class.getResource("/View/MainPage.fxml"));
        Stage stage = (Stage) exitDone.getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);


    }
}
