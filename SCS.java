package Model;
import java.util.Scanner;
import java.util.ArrayList;

public class SCS {

    public static void main(String[] args){
        PointFactory factory = new PointFactory();
        ArrayList<Point> points = factory.parseData();
        BinFactory binFactory = new BinFactory(points);
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the lower bound of the periods to scan: ");
        int start = reader.nextInt();
        System.out.println("Enter the upper bound of the periods to scan: ");
        int end = reader.nextInt();
        System.out.println("Enter the number of bins: ");
        int number_bins = reader.nextInt();
        reader.close();
        ArrayList<Bin> bins = binFactory.binCreation(start, end, number_bins);
        for (Bin bin: bins){
            System.out.println(bin.getStart());
            System.out.println(bin.getEnd());
            System.out.println(bin.getMvar());
            System.out.println(bin.getPairs().size());
        }
    }
}
