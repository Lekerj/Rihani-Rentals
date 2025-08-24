package Vehicles;

/**
 * Electric passenger car with a maximum driving range (km). Plate numbers prefixed with EC.
 * @author Ahmed Gara Ali
 * @version 1.0
 * @since 1.0
 */
public class ElectricCar extends Car {
    /** Maximum range (kilometers) per full charge. */
    private double cKMRange; // Maximum range of the electric car in km
    /** Sequential counter for plate generation. */
    private static int ECCount = 1001; // counter for Electric Cars

    /** Default constructor. */
    public ElectricCar() {
        super();
        this.cKMRange = 0;
    }

    /**
     * Full constructor.
     * @param make manufacturer
     * @param model model
     * @param prodyear production year
     * @param passengerCap passenger capacity
     * @param kmRange max range in km
     */
    public ElectricCar(String make, String model, int prodyear, int passengerCap, double kmRange) {
        super(make, model, prodyear, passengerCap);
        this.plateNumber ="EC"+ECCount++;
        this.cKMRange = kmRange;
    }

    /**
     * Copy constructor (new plate number issued).
     * @param anECar source electric car
     */
    public ElectricCar(ElectricCar anECar) {
        super(anECar);
        this.plateNumber ="EC"+ECCount++;
        this.cKMRange = anECar.cKMRange;
    }

    /** @return max range in km */
    public double getcKMRange() {
        return cKMRange;
    }

    /** @param cKMRange new max range (km) */
    public void setcKMRange(double cKMRange) {
        this.cKMRange = cKMRange;
    }

    /**
     * Equality check including range.
     * @param anECar other electric car
     * @return true if logically equal
     */
    public boolean equals(ElectricCar anECar) {
        return super.equals(anECar) && this.cKMRange == anECar.cKMRange;
    }

    /** @return formatted electric car details */
    public String toString() {
        return super.toString() + "\nMaximum Range (km): " + this.cKMRange + "KM";
    }
}
