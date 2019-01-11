package Model;

import java.util.ArrayList;

public class Bin {

    private double mvar;

    private double start;

    private double end;

    private ArrayList<Pointpair> pairs;

    /**
     * Creates a Model.Bin containing all the pairs of points separated from each other by a time interval between start and
     * end time. End time has to be greater than start time.
     * @param start: Start time of the Model.Bin
     * @param end: End time of the Model.Bin
     * @param pointpairs: all the pointpairs that are being analyzed.
     */
    public Bin (double start, double end, ArrayList<Pointpair> pointpairs) {
       this.start = start;
       this.end = end;
        double total_mvar = 0;
        pairs = new ArrayList<>();
        int number_of_pairs = pointpairs.size();
        if (number_of_pairs == 0 || end == start) {
            pairs = new ArrayList<Pointpair>();
            this.mvar = 0;
        } else {
            for (Pointpair pair : pointpairs) {
                if ((start <= pair.getTvar()) & (pair.getTvar() <= end)) {
                    pairs.add(pair);
                    total_mvar += pair.getMvar();
                }
            }
            if (pairs.size() == 0){
                this.mvar = 0;
            }else {
                this.mvar = total_mvar / pairs.size();
            }
        }
    }

    public double getMvar() {
        return mvar;
    }

    public double getStart() {
        return start;
    }

    public double getEnd() {
        return end;
    }

    public ArrayList<Pointpair> getPairs() {
        return pairs;
    }
}
