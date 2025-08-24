package Vehicles;

/**
 * Represents a generic passenger car (gas, electric) extending Vehicle.
 * Adds passenger capacity specific to cars.
 * @author Ahmed Gara Ali
 * @version 1.0
 * @since 1.0
 */
public class Car extends Vehicle {

    /** Maximum passenger capacity of the car. */
    protected int PassengerCap; // Maximum passenger capacity of the car

    /**
     * Default constructor initializing capacity to 0.
     */
    public Car() {
        super();
        this.PassengerCap = 0;
    }

    /**
     * Parameterized constructor.
     * @param make manufacturer
     * @param model model
     * @param prodyear production year
     * @param passengerCap maximum passengers
     */
    public Car(String make, String model, int prodyear, int passengerCap) {
        super(make, model, prodyear);
        this.PassengerCap = passengerCap;
    }

    /**
     * Copy constructor.
     * @param aCar car to copy
     */
    public Car(Car aCar) {
        super(aCar);
        this.PassengerCap = aCar.PassengerCap;
    }

    /**
     * Passenger capacity getter.
     * @return passenger capacity
     */
    public int getPassengerCap() {
        return PassengerCap;
    }

    /**
     * Passenger capacity setter.
     * @param passengerCap new capacity
     */
    public void setPassengerCap(int passengerCap) {
        PassengerCap = passengerCap;
    }

    /**
     * Compares two cars for logical equality (class + attributes).
     * @param aCar other car
     * @return true if equal
     */
    public boolean equals(Car aCar) {
       if(aCar!=null){
        return super.equals(aCar) && this.PassengerCap == aCar.PassengerCap;}
        else return false;
    }

    /**
     * Builds string representation including passenger capacity.
     * @return formatted string
     */
    public String toString() {
        return super.toString() + "\nMaximum Passengers Capacity: " + this.PassengerCap;
    }
}
