package Controller;

import Model.SCS;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

public class SelectionPageController {

    static public File file;

    @FXML
    private Button chooseBtn;


    @FXML
    private TextArea fileChooseTxt;

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;


    public SelectionPageController(){

    }

    @FXML
    private void initialize(){

    }
    @FXML
    private void chooseFile() throws IOException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Stage stage = (Stage) chooseBtn.getScene().getWindow();
        File tempfile = fileChooser.showOpenDialog(stage);
        if(tempfile == null){
            SelectionPageController.file = new File("data.csv");
            fileChooseTxt.setText(file.getName() + " (default data file)");
        }else {
            SelectionPageController.file = tempfile;
            fileChooseTxt.setText(file.getName());
        }
    }

    @FXML
    private void goToMainPage() throws IOException{
        FXMLLoader loader = new FXMLLoader(SelectionPageController.class.getResource("/View/MainPage.fxml"));
        Stage stage = (Stage) chooseBtn.getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        SCS.start1(file);
    }
}
