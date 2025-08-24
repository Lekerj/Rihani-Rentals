package Vehicles;

/**
 * Generic truck abstraction extending Vehicle adding a weight capacity.
 * Parent class for specific truck fuel / energy types.
 * @author RVM Team
 * @version 1.0
 * @since 1.0
 */
public class Truck extends Vehicle {

    /** Maximum weight capacity (kg). */
    protected double WeightCap; // Maximum weight capacity of the truck (kg)

    /** Default constructor. */
    public Truck() {
        super();
        this.WeightCap = 0;
    }

    /**
     * Parameterized constructor.
     * @param make manufacturer
     * @param model model
     * @param prodyear production year
     * @param WeightCap maximum load capacity (kg)
     */
    public Truck(String make, String model, int prodyear, double WeightCap) {
        super(make, model, prodyear);
        this.WeightCap = WeightCap;
    }

    /**
     * Copy constructor.
     * @param aTruck truck to copy
     */
    public Truck(Truck aTruck) {
        super(aTruck);
        this.WeightCap = aTruck.WeightCap;
    }

    /** @return weight capacity in kg */
    public double getWeightCap() {
        return WeightCap;
    }

    /** @param weightCap new weight capacity */
    public void setWeightCap(double weightCap) {
        WeightCap = weightCap;
    }

    /**
     * Logical equality check.
     * @param aTruck other truck
     * @return true if equal
     */
    public boolean equals(Truck aTruck) {
        if (aTruck != null) {
            return super.equals(aTruck) && this.WeightCap == aTruck.WeightCap;
        } else {
            return false;
        }
    }

    /** @return formatted truck details including capacity */
    public String toString() {
        return super.toString() + "\nMaximum Weight Capacity (kg): " + this.WeightCap+"kg";
    }

}
