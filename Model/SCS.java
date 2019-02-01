package Model;
import javafx.scene.chart.XYChart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class SCS {

    static public double start;
    static public double end;
    static public int number_bins;
    static private BinFactory binFactory;

    public SCS() {
    }
    static public void start1(File dataFile) throws IOException{
            PointFactory factory = new PointFactory(dataFile);
            ArrayList<Point> points = factory.parseData();
            binFactory = new BinFactory(points);
        }

    static public ArrayList<Bin> start2( double start, double end, int number_bins){
        SCS.start = start;
        SCS.end = end;
        SCS.number_bins = number_bins;
        ArrayList<Bin> bins = binFactory.binCreation(start, end, number_bins);
        return bins;
    }

}

