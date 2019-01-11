package Model;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PointFactory {

    private final String dataFilePath; // the file path for the data

    private File dataFile;

    public PointFactory(){
        dataFilePath = "data.csv";
        dataFile = new File(dataFilePath);
    }

    public ArrayList<Point> parseData(){
        try{
            ArrayList<Point> data = new ArrayList<>();
            BufferedReader console = new BufferedReader(new FileReader(dataFilePath));
            String line = console.readLine();
            String[] rawDataLine;

            while (line != null) {
                rawDataLine = line.split(",\\s*");
                data.add(convertToPoint(rawDataLine));
                line = console.readLine();
            }
            return data;

        } catch (FileNotFoundException exception) {
        System.err.println("The file was not found.");

    } catch (IOException exception) {
        System.err.println("An error occurred.");
    }

        return null;
}

    public Point convertToPoint(String[] line){
       Double date = Double.parseDouble(line[0]);
       Double magnitude = Double.parseDouble(line[1]);
       return new Point(date, magnitude);
    }
    }


