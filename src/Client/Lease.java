package Client;
import Vehicles.*;

/**
 * Represents a lease contract linking a client to a vehicle and tracking activation status.
 * @author Ahmed Gara Ali
 * @version 1.0
 * @since 1.0
 */
public class Lease {

    /** Client associated with this lease. */
    private Client aClient; // Client with the lease
    /** Vehicle associated with this lease. */
    private Vehicle aVehicle; // Vehicle with the lease
    /** Active status flag (true while lease in effect). */
    private boolean isActive = true; // Lease status
    /** Global lease counter. */
    public static int LeaseCount = 0; // Counter for total leases

    /** Default constructor creates an inactive placeholder lease. */
    public Lease() {
        this.aClient = null;
        this.aVehicle = null;
        aVehicle.ModifyLeaseStatus(isActive); // Modifies lease status of the vehicle
    }

    /**
     * Creates an active lease for the given client and vehicle.
     * @param aClient client leasing
     * @param aVehicle vehicle leased
     */
    public Lease(Client aClient, Vehicle aVehicle) {
        this.aClient = aClient;
        this.aVehicle = aVehicle;
        aVehicle.ModifyLeaseStatus(isActive); // Modifies lease status of the vehicle (activates)
    }

    /**
     * Copy constructor performing deep copy for client & vehicle references.
     * @param aLease lease to copy
     */
    public Lease(Lease aLease) {
        this.aVehicle = new Vehicle(aLease.aVehicle);
        this.aClient = new Client(aLease.aClient);
        aLease.aVehicle.ModifyLeaseStatus(isActive); // Modifies lease status of the vehicle (activates)
    }

    /** @return client on the lease */
    public Client getClient() { return aClient; }
    /** @param aClient new client */
    public void setClient(Client aClient) { this.aClient = aClient; }
    /** @return leased vehicle */
    public Vehicle getVehicle() { return aVehicle; }
    /** @param aVehicle new vehicle */
    public void setVehicle(Vehicle aVehicle) { this.aVehicle = aVehicle; }

    /**
     * Logical equality compares client and vehicle.
     * @param aLease other lease
     * @return true if same parties
     */
    public boolean equals(Lease aLease) {
        return this.aClient.equals(aLease.aClient) && this.aVehicle.equals(aLease.aVehicle);
    }

    /**
     * String representation of lease details.
     * @return formatted lease description
     */
    public String toString() {
        return "Lease Signed by: " + aClient.toString() + "\nFor Vehicle: " + aVehicle.toString();
    }
}
