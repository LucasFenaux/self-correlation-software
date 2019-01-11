package Model;

import Model.Bin;

import java.util.ArrayList;

public class BinFactory {

    public ArrayList<Point> data;

    public BinFactory(ArrayList<Point> data) {
        this.data = data;
    }

    public ArrayList<Bin> binCreation(int start, int end, int number_bins){
        ArrayList<Bin> output = new ArrayList<>();
        double bin_interval = (end - start)/number_bins;
        ArrayList<Pointpair> pointpairs = pointPairCreation();
        double begin_bin = start;
        double end_bin = start + bin_interval;
        int i = 0;
        while (i < number_bins){
            ArrayList<Pointpair> pp_for_bin = new ArrayList<>();
            for (Pointpair pointpair : pointpairs){
                if ((begin_bin <= pointpair.getTvar())&(pointpair.getTvar() <= end_bin)){
                    pp_for_bin.add(pointpair);
                }
            }
            output.add(new Bin(begin_bin, end_bin, pp_for_bin));

            begin_bin = end_bin;
            end_bin = end_bin + bin_interval;
            i += 1;
        }

        return output;
    }

    private ArrayList<Pointpair> pointPairCreation(){
        int i = 0;
        int j = 0;
        ArrayList<Pointpair> output = new ArrayList<>();
        while(i < data.size()){
            Point point1 = data.get(i);
            while(j < data.size()){
                Point point2 = data.get(j);
                output.add(new Pointpair(point1, point2));
                j += 1;
            }
            i += 1;
            j = i +1;
        }
        return output;
    }
}
