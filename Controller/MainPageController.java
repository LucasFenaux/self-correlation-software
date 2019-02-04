package Controller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.lang.Number;
import java.lang.Double;

import Model.Bin;
import Model.SCS;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class MainPageController {

    private XYChart.Series<Number, Number> data;
    private ArrayList<Bin> bins;
    private double ymin;
    private double ymax;
    private double ystep;

    @FXML
    private TextField FilePathTxt;

    @FXML
    private TextField lowerBoundTxt;

    @FXML
    private TextField upperBoundTxt;

    @FXML
    private TextField binTxt;

    @FXML
    private Button startBtn;

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;


    public MainPageController(){

    }

    @FXML
    private void initialize(){

    }
    @FXML
    private void printGraph() throws IOException{
        this.bins = SCS.start2(Double.parseDouble(lowerBoundTxt.getText()),
                Double.parseDouble(upperBoundTxt.getText()), Integer.parseInt(binTxt.getText()));
        this.data = new XYChart.Series<>();
        data.setName("Bin data");
        for (Bin bin : bins) {
            data.getData().add(new XYChart.Data<>(bin.getAverage(), bin.getMvar()));
        }
        double min = bins.get(0).getMvar();
        for (Bin bin: bins){
            if (bin.getMvar() < min){
                min = bin.getMvar();
            }
        }
        double max = bins.get(0).getMvar();
        for (Bin bin: bins){
            if (bin.getMvar() > max){
                max = bin.getMvar();
            }
        }
        ymin = min;
        ymax = max;
        ystep = max/bins.size();
        FXMLLoader loader = new FXMLLoader(MainPageController.class.getResource("/View/GraphPage.fxml"));
        Stage stage = (Stage) startBtn.getScene().getWindow();

        stage.setTitle("Results");

        NumberAxis xAxis = new NumberAxis(SCS.start, SCS.end, SCS.number_bins);
        NumberAxis yAxis = new NumberAxis(Double.max(0, ymin-ystep), ymax + ystep, ystep);

        ScatterChart<Number,Number> sc = new ScatterChart<Number,Number>(xAxis,yAxis);
        sc.setPrefSize(700, 400);
        sc.setLayoutX(25);
        sc.setLayoutY(10);
        sc.setTitle("Results");
        sc.getData().add(data);
        sc.setId("ScatterChart");


        Scene scene = new Scene(new Group());
        ((Group)scene.getRoot()).getChildren().add(loader.load());
        ((Group)scene.getRoot()).getChildren().add(sc);
        stage.setScene(scene);

    }

    @FXML
    private void returnToSelection() throws IOException{
        FXMLLoader loader = new FXMLLoader(MainPageController.class.getResource("/View/SelectionPage.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) startBtn.getScene().getWindow();
        stage.setScene(scene);

    }




}
