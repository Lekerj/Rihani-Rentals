package Vehicles;

/**
 * Concrete gasoline-powered car implementation.
 * Generates a plate number with prefix GC.
 * @author Ahmed Gara Ali
 * @version 1.0
 * @since 1.0
 */
public class GasCar extends Car {

    /** Sequential counter used to generate plate numbers (GCxxxx). */
    private static int GCCount = 1001; // counter for Gas Cars

    /** Default constructor. */
    public GasCar() {
        super();
    }

    /**
     * Full constructor.
     * @param make manufacturer
     * @param model model
     * @param prodyear production year
     * @param passengerCap passenger capacity
     */
    public GasCar(String make, String model, int prodyear, int passengerCap) {
        super(make, model, prodyear, passengerCap);
        this.plateNumber ="GC"+GCCount++;
    }

    /**
     * Copy constructor (new plate issued).
     * @param aGasCar source car
     */
    public GasCar(GasCar aGasCar) {
        super(aGasCar);
        this.plateNumber ="GC"+GCCount++;
    }

    /**
     * Equality check defers to car attribute comparison.
     * @param aGasCar other gas car
     * @return true if logically equal
     */
    public boolean equals(GasCar aGasCar) {
        return super.equals(aGasCar);
    }

    /**
     * Textual representation.
     * @return string with attributes
     */
    public String toString() {
        return super.toString();
    }
}
