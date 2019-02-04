package Model;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PointFactory {

    private  File dataFile; // the file path for the data
    private String fileType;  //stores the type of the file for the parsing (".csv" or ".dat")

    public PointFactory(File dataFile) throws IOException{
        this.dataFile = dataFile;
        String tempfiletype = dataFile.getCanonicalPath();
        if (tempfiletype.contains(".csv")){
            fileType = ".csv";
        }else if (tempfiletype.contains(".dat")){
            fileType = ".dat";
        }else
            fileType = "Not a supported type";
        }


    public ArrayList<Point> parseData(){
        try{
            ArrayList<Point> data = new ArrayList<>();
            BufferedReader console = new BufferedReader(new FileReader(dataFile.getAbsoluteFile()));
            String line = console.readLine();
            String[] rawDataLine;
            if (fileType.equals(".csv")){
            while ((line != null) && (!line.trim().equals(""))){
                rawDataLine = line.split(",\\s*");
                rawDataLine[1] = rawDataLine[1].replaceAll(">", "");
                rawDataLine[1] = rawDataLine[1].replaceAll("<", "");
                rawDataLine[0] = rawDataLine[0].replaceAll("<", "");
                rawDataLine[0] = rawDataLine[0].replaceAll(">", "");

                data.add(convertToPoint(rawDataLine));
                line = console.readLine();
            }
            }else if(fileType.equals(".dat")){
                while ((line != null) && (!line.trim().equals(""))) {
                    rawDataLine = line.split("\\t");
                    rawDataLine[1] = rawDataLine[1].replaceAll(">", "");
                    rawDataLine[1] = rawDataLine[1].replaceAll("<", "");
                    rawDataLine[0] = rawDataLine[0].replaceAll("<", "");
                    rawDataLine[0] = rawDataLine[0].replaceAll(">", "");

                    data.add(convertToPoint(rawDataLine));
                    line = console.readLine();
                }
                }else{
                System.err.println(fileType);
            }

            return data;

        } catch (FileNotFoundException exception) {
        System.err.println("The file was not found.");

    } catch (IOException exception) {
        System.err.println("An error occurred.");
    }
    catch (ArrayIndexOutOfBoundsException exception){
            System.err.println("File has correct type but the data in it is not correctly formatted");
    }

        return null;
}

    public Point convertToPoint(String[] line){
       Double date = Double.parseDouble(line[0]);
       Double magnitude = Double.parseDouble(line[1]);
       return new Point(date, magnitude);
    }
    }


