package Vehicles;

/**
 * Diesel powered truck extending Truck adding fuel capacity.
 * Plate numbers prefixed with DT.
 * @author Ahmed Gara Ali
 * @version 1.0
 * @since 1.0
 */
public class DieselTruck extends Truck {

    /** Maximum fuel capacity (L). */
    private double fuelCap; // Maximum fuel capacity of diesel truck (L)
    /** Sequential counter for plate generation. */
    private static int Dcount = 1001; // counter for Diesel Trucks

    /** Default constructor. */
    public DieselTruck() {
        super();
        this.fuelCap = 0;
    }

    /**
     * Full constructor.
     * @param make manufacturer
     * @param model model
     * @param prodyear production year
     * @param WeightCap max weight capacity (kg)
     * @param fuelCap max fuel capacity (L)
     */
    public DieselTruck(String make, String model, int prodyear, double WeightCap, double fuelCap) {
        super(make, model, prodyear, WeightCap);
        this.plateNumber ="DT"+Dcount++;
        this.fuelCap = fuelCap;
    }

    /**
     * Copy constructor (assigns new plate number).
     * @param aDTruck source truck
     */
    public DieselTruck(DieselTruck aDTruck) {
        super(aDTruck);
        this.fuelCap = aDTruck.fuelCap;
        this.plateNumber ="DT"+Dcount++;
    }

    /** @return fuel capacity (L) */
    public double getFuelCap() {
        return fuelCap;
    }

    /** @param fuelCap new fuel capacity (L) */
    public void setFuelCap(double fuelCap) {
        this.fuelCap = fuelCap;
    }

    /**
     * Equality including fuel capacity.
     * @param aDTruck other diesel truck
     * @return true if equal
     */
    public boolean equals(DieselTruck aDTruck) {
        return super.equals(aDTruck) && this.fuelCap == aDTruck.fuelCap;
    }

    /** @return formatted diesel truck details */
    public String toString() {
        return super.toString() + "\nMaximum Fuel Capacity: " + this.fuelCap + "L";
    }
}
