package Model;

import java.util.ArrayList;

public class Point {
    /**
     * This class represents a data point that we got from the csv file.
     */
    /**
     * The point's date
     */
    private double date;

    /**
     * The point's magnitude
     */
    private double magnitude;

    /**
     * Initializes a data point
     * @param date : the date at which the data point was taken
     * @param magnitude : the magnitude of the data point
     */
    public Point(double date, double magnitude) {
        this.date = date;
        this.magnitude = magnitude;
    }

    /**
     * Whether two points are equal or not
     * @param o: an Object, normally another point
     * @return : If not a Model.Point, return false.
     *           If o is a point and it has the same date and magnitude as this point, then return true.
     */
    @Override
    public boolean equals(Object o){
        if (o == null || getClass() != o.getClass()) return false;
        Point opoint = (Point) o;
        return (date == opoint.getDate())&(magnitude == opoint.getMagnitude());

    }


    /*
    Getters
     */
    public double getDate() {
        return date;
    }

    public double getMagnitude() {
        return magnitude;
    }

}
