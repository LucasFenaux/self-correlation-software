package Model;

import java.util.ArrayList;

public class Pointpair {
    /*
     * This class represents a pair of data points, we will put pairs of data points in the bins instead of
     * data points themselves. We made a class instead of a just using a tuple so that we can have functions behaving
     * on the pair inside a different class than the Model.Bin class so that we don't overload the Model.Bin class.
     */
    /**
     * The first data point of the pair
     */
    private Point point1;
    /**
     * The second data point of the pair
     */
    private Point point2;
    /**
     * The time variation between the two data points
     */
    private double tvar;
    /**
     * The magnitude variation between the two data points
     */
    private double mvar;

    /**
     * Initializes a Model.Pointpair (order doesn't matter).
     * @param point1 : One of the point of the pointpair.
     * @param point2 : Other point of the pointpair.
     */
    public Pointpair(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        this.tvar = Math.abs(point1.getDate() - point2.getDate());
        this.mvar = Math.abs(point1.getMagnitude() - point2.getMagnitude());
    }

    /**
     * Two pointpairs are equals iff each point in a pair matches a point in the other pair (order doesn't matter)
     * @param o : an Object, normally another Model.Pointpair
     * @return : If not a Model.Pointpair, returns false.
     *           If o is a Model.Pointpair, then returns true iff each point in a pair matches a point in the other pair
     *           (order doesn't matter)
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pointpair opair = (Pointpair) o;
        Point opoint1 = opair.getPointpair().get(0);
        Point opoint2 = opair.getPointpair().get(1);
        return (point1.equals(opoint1) & point2.equals(opoint2)) || (point1.equals(opoint2) & point2.equals(opoint1));
    }

    /*
    Getters
     */

    public ArrayList<Point> getPointpair() {
        ArrayList<Point> pointpair = new ArrayList<Point>();
        pointpair.add(0, point1);
        pointpair.add(1, point2);
        return pointpair;
    }

    public double getTvar() {
        return tvar;
    }

    public double getMvar() {
        return mvar;
    }

}

