package Vehicles;

/**
 * Electric truck variant with an energy range (km). Plate numbers prefixed with ET.
 * @author RVM Team
 * @version 1.0
 * @since 1.0
 */
public class ElectricTruck extends Truck {

    /** Maximum driving range on full charge (km). */
    private double kmRange; // Maximum range of the electric truck (km)
    /** Sequential counter for plate generation. */
    private static int ETcount = 1001; // counter for Electric Trucks

    /** Default constructor. */
    public ElectricTruck() {
        super();
        this.kmRange = 0;
    }

    /**
     * Full constructor.
     * @param make manufacturer
     * @param model model
     * @param prodyear production year
     * @param WeightCap maximum weight capacity (kg)
     * @param kmRange maximum range (km)
     */
    public ElectricTruck(String make, String model, int prodyear, double WeightCap, double kmRange) {
        super(make, model, prodyear, WeightCap);
        this.plateNumber = "ET" + ETcount++;
        this.kmRange = kmRange;
    }

    /**
     * Copy constructor (issues new plate).
     * @param aETruck source electric truck
     */
    public ElectricTruck(ElectricTruck aETruck) {
        super(aETruck);
        this.kmRange = aETruck.kmRange;
        this.plateNumber = "ET" + ETcount++;
    }

    /** @return range (km) */
    public double getKmRange() {
        return kmRange;
    }

    /** @param kmRange new range (km) */
    public void setKmRange(double kmRange) {
        this.kmRange = kmRange;
    }

    /**
     * Equality including range.
     * @param aETruck other electric truck
     * @return true if equal
     */
    public boolean equals(ElectricTruck aETruck) {
            return super.equals(aETruck) && this.kmRange == aETruck.kmRange;
    }

    /** @return formatted electric truck details */
    public String toString() {
        return super.toString() + "\nMaximum Range (km): " + this.kmRange + "km";
    }
}