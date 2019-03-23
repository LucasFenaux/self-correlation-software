package Controller;
import java.io.*;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class MainPageController {

    private XYChart.Series<Number, Number> data;
    private ArrayList<Bin> bins;
    private double ymin;
    private double ymax;
    private double ystep;
    private boolean extract_data = false;
    private boolean overwrite = false;

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

    @FXML
    private CheckBox extract_results_checkbox;

    @FXML
    private CheckBox ovewrite_checkbox;


    public MainPageController(){

    }

    @FXML
    private void initialize(){

    }

    @FXML
    private void selectedExtract(){
        extract_data = true;
    }

    @FXML
    private void selectedOverwrite(){
        overwrite = true;
    }

    @FXML
    private void printGraph() throws IOException{
        this.bins = SCS.start2(Double.parseDouble(lowerBoundTxt.getText()),
                Double.parseDouble(upperBoundTxt.getText()), Integer.parseInt(binTxt.getText()));
        if(extract_data) {
            File outputFile = new File("results.csv");
            if (overwrite){
                if (outputFile.exists()){
                    outputFile.delete();
                }
            }
            try {
                Writer output = new BufferedWriter(new FileWriter("results.csv", true));
                for (Bin bin : bins) {
                    StringBuilder item = new StringBuilder();
                    item.append(Double.toString(bin.getAverage()));
                    item.append(",");
                    item.append(Double.toString(bin.getMvar()));
                    output.append(item);
                    output.append(System.lineSeparator());
                }
                output.close();
            } catch (IOException exception){
                System.err.println("could not open the file to extract the data results");
            }
        }
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
        ystep = (max-min)/bins.size();
        FXMLLoader loader = new FXMLLoader(MainPageController.class.getResource("/View/GraphPage.fxml"));
        Stage stage = (Stage) startBtn.getScene().getWindow();

        stage.setTitle("Results");

        NumberAxis xAxis = new NumberAxis(SCS.start, SCS.end, (SCS.end - SCS.start)/SCS.number_bins);
        NumberAxis yAxis = new NumberAxis(0, ymax + ystep, ystep);

        ScatterChart<Number,Number> sc = new ScatterChart<Number,Number>(xAxis,yAxis);
        sc.setPrefSize(750, 450);
        sc.setLayoutX(75);
        sc.setLayoutY(30);
        sc.setTitle("     Self-correlation analysis");
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
