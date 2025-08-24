package Vehicles.Manager;
import java.util.Scanner;

import Client.*;
import Driver.RihaniVehicles; // added for standardized menus

/**
 * Manages lease lifecycle operations: create (lease), return, list leases, and filter leased vehicles/clients.
 * Uses simple in-memory arrays for storage and console interaction for input/output.
 * @author Ahmed Gara Ali
 * @version 1.0
 * @since 1.0
 */
public class LeaseManager{

    /** Array holding all active (and historical) leases. */
    private static Lease[] LeaseList=null; //Array for all leases
    /** Shared scanner for lease operations. */
    public static Scanner input = new Scanner(System.in);

    /**
     * Lease management main menu loop (interactive).
     */
    public static void LeaseManagementMenu(){
        boolean LeaseMenuControl=true;
        while(LeaseMenuControl){
            RihaniVehicles.printMenu("Lease Management","Select an action", new String[]{
                "Lease a Vehicle to a Client",
                "Return a Vehicle from a Client",
                "Show all vehicles leased by a client",
                "List all Vehicles that are currently leased",
                "Exit Lease Menu"});
            System.out.print("Enter choice: ");
            switch(input.nextInt()){
                case 1:
                    LeaseCar();
                    break;
                case 2:
                    ReturnVehicle();
                    break;
                case 3:
                    DisplayClientLeased();
                    break;
                case 4:
                    DisplayLeasedVehicles();
                    break;
                case 5:
                    LeaseMenuControl=false;
                    break;
                default: System.out.println("Invalid option.");
                }
            }
        }

        /**
         * Adds a lease object to an existing lease array, growing it by one.
         * @param l existing lease array (may be null)
         * @param newL new lease to append
         * @return expanded array containing new lease
         */
    public static Lease[] addLeaseMechanism(Lease[] l, Lease newL){

        if(l==null){
            Lease[] aNewLeaseList = new Lease[1];

            aNewLeaseList[0]=newL;
            return aNewLeaseList;
        }
        else {

            Lease[] aNewLeaseList = new Lease[l.length+1];

            for(int i=0;i<l.length;i++){
                aNewLeaseList[i]=l[i];
            }

            aNewLeaseList[aNewLeaseList.length-1]=newL;
            System.out.println("Vehicle is Leased!");
            return aNewLeaseList;
        }

    }

    /**
     * Lists all vehicles leased by a selected client (based on equality of client objects).
     */
    public static void DisplayClientLeased(){

        if(ClientManager.getClientArray()==null || ClientManager.getClientArray().length==0){
            System.out.println("No Clients is registered in the system.");
            return;
        }
        else if(LeaseList==null || LeaseList.length==0){
            System.out.println("No lease has been signed yet.");
            return;
        }

        ClientManager.DisplayClients();
        boolean LeasedFilterControl = true;
        while (LeasedFilterControl){


            System.out.print("Which Client would you like to see if he is currently leasing?:");
            int LeaseFilterIndex= input.nextInt();
            input.nextLine();

            if(LeaseFilterIndex>=1 || LeaseFilterIndex<=LeaseList.length){

                for(int i=0;i<LeaseList.length;i++){

                    if(ClientManager.getClientArray()[LeaseFilterIndex-1].equals(LeaseList[i].getClient())){

                        System.out.println(LeaseList[i].getVehicle());
                        System.out.println();
                    }
                    else{
                        System.out.println("The following Client has not leased a Vehicle yet\n\n"+ClientManager.getClientArray()[LeaseFilterIndex-1]);
                    }
                }

                LeasedFilterControl=false;
            }
            else{

                System.out.println("Option does not exist! Try again!");

            }
        }
    }

    /**
     * Displays all vehicles currently flagged as leased across all vehicle subtype arrays.
     */
    public static void DisplayLeasedVehicles(){

        System.out.println("---Leased Gas Cars---");
        if(VehicleManager.getGasCars()==null || VehicleManager.getGasCars().length==0){
            System.out.println("No Gas Cars Registered");
          }
          else{
                 for(int i=0;i<VehicleManager.getGasCars().length;i++){
                     if(VehicleManager.getGasCars()[i].VehicleLeaseStatus()==true){
                    System.out.println(VehicleManager.getGasCars()[i]);
            }
            }
        }

        System.out.println("---Leased Electric Cars---");
        if(VehicleManager.getElectricCars()==null || VehicleManager.getElectricCars().length==0){
            System.out.println("No Electric Cars Registered");
          }
        else{
            for(int i=0;i<VehicleManager.getElectricCars().length;i++){
                if(VehicleManager.getElectricCars()[i].VehicleLeaseStatus()==true){
                    System.out.println(VehicleManager.getElectricCars()[i]);
            }
        }
    }

        System.out.println("---Leased Diesel Trucks---");
        if(VehicleManager.getDieselTrucks()==null || VehicleManager.getDieselTrucks().length==0){
            System.out.println("No Diesel Trucks Registered");
          }
          else{
        for(int i=0;i<VehicleManager.getDieselTrucks().length;i++){
            if(VehicleManager.getDieselTrucks()[i].VehicleLeaseStatus()==true){
                System.out.println(VehicleManager.getDieselTrucks()[i]);
            }
        }}

        System.out.println("---Leased Electric Trucks---");
        if(VehicleManager.getElectricTrucks()==null || VehicleManager.getElectricTrucks().length==0){
            System.out.println("No Electric Trucks Registered");
          }
          else{
        for(int i=0;i<VehicleManager.getElectricTrucks().length;i++){
            if(VehicleManager.getElectricTrucks()[i].VehicleLeaseStatus()==true){
                System.out.println(VehicleManager.getElectricTrucks()[i]);
            }
        }
     }

    }

    /**
     * Prints all recorded leases (active or not) to console.
     */
    public static void displayLeases(){

        if(LeaseList==null||LeaseList.length==0){
            System.out.println("No Vehicle has been leased yet!");
            return;
        }

        else {
            System.out.println();
            for(int i=0 ; i<LeaseList.length;i++){
                System.out.println("Lease "+(i+1)+":\n"+LeaseList[i]);
                System.out.println();
            }
            System.out.println();

        }
    }

    /**
     * Returns a vehicle (terminates a lease) by selecting an existing lease record.
     * Updates vehicle lease status and shrinks lease array.
     */
    public static void ReturnVehicle(){

        if(LeaseList==null || LeaseList.length==0){
            System.out.println("Cannot return any vehicle since no leases has been signed!");
            return;
        }

        displayLeases();
        boolean ReturnOptionControl=true;
        while(ReturnOptionControl){

        System.out.println("Which Lease Contract is being returned?");
        System.out.print("(Refer to Client Information or Vehicle Information):");
        int LeaseNumberReturn = input.nextInt();
        input.nextLine();


        if(LeaseNumberReturn>0 && LeaseNumberReturn<=LeaseList.length){

            Lease[] RemovedLeaseList = new Lease[LeaseList.length-1];

            LeaseList[LeaseNumberReturn-1].getVehicle().ModifyLeaseStatus(false);
            int iFollower = 0;


                for(int i =0;i<LeaseList.length;i++){

                    if(i!=(LeaseNumberReturn-1)){
                        RemovedLeaseList[iFollower]=LeaseList[i];
                        iFollower++;
                    }
                }

                LeaseList=RemovedLeaseList;
                System.out.println("Vehicle Returned! Contract Terminated!");

        ReturnOptionControl=false;
            }

        else {
            System.out.println("Option does not exist! Try again!");
          }
        }
    }

    /**
     * Interactive workflow to create a lease linking a client to a chosen available vehicle.
     */
    public static void LeaseCar(){
            if(ClientManager.getClientArray()==null || ClientManager.getClientArray().length==0){
                System.out.println("No clients registered! Cannot lease a vehicle!");
                return;
            }
            ClientManager.DisplayClients();
            boolean LeaseCarControl = true;
            while(LeaseCarControl){
            System.out.println("Who would like to lease a Vehicle?");
            System.out.print("Enter the client number of the client:");
            int ClientInex = input.nextInt();
            input.nextLine();

            if(ClientInex<1 || ClientInex >ClientManager.getClientArray().length){
                System.out.println("Option does not exist! Returning.");
                return;
            }

            if(ClientInex>=1 && ClientInex <= ClientManager.getClientArray().length){
                boolean LeaseCarTypeControl=true;
                while(LeaseCarTypeControl){
                    RihaniVehicles.printMenu("Lease Vehicle","Which type of Vehicle would you like to lease?", new String[]{
                        "A Gas Car",
                        "An Electric Car",
                        "A Diesel Truck",
                        "An Electric Truck",
                        "Exit Lease Vehicle Menu"});
                    System.out.print("Enter choice: ");
            int VehcileTypeLease = input.nextInt();
            input.nextLine();

            switch (VehcileTypeLease) {
                case 1:

                if(VehicleManager.getGasCars()==null){
                    System.out.println("No Gas Car has been registered yet!");
                    return;
                }

                VehicleManager.ListAllVehicles(VehicleManager.getGasCars());

                System.out.print("Choose what vehicle does the Client want to lease:");
                int GasCarLease = input.nextInt();
                input.nextLine();

                if(VehicleManager.getGasCars()[GasCarLease-1].VehicleLeaseStatus()==false){

                    VehicleManager.getGasCars()[GasCarLease-1].ModifyLeaseStatus(true); //Just noticed there's no point for this (taken care of by lease constructor)

                Lease newLease = new Lease(ClientManager.getClientArray()[ClientInex-1], VehicleManager.getGasCars()[GasCarLease-1]);

                LeaseList = addLeaseMechanism(LeaseList, newLease);

                System.out.println("Contract sucessfully has been added!");

                LeaseCarTypeControl=false;
                LeaseCarControl =false;
                    break;
                }
                else {System.out.println("This Vehicle is already leased!");
                    break;
                }

                case 2:

                if(VehicleManager.getElectricCars()==null){
                    System.out.println("No Electric Car has been registered yet!");
                    return;
                }

                VehicleManager.ListAllVehicles(VehicleManager.getElectricCars());

                System.out.print("Choose what vehicle does the Client want to lease:");
                int EletricCarLease = input.nextInt();
                input.nextLine();

                if(VehicleManager.getElectricCars()[EletricCarLease-1].VehicleLeaseStatus()==false){

                VehicleManager.getElectricCars()[EletricCarLease-1].ModifyLeaseStatus(true); //Just noticed there's no point for this (taken care of by lease constructor)

                Lease newLease2 = new Lease(ClientManager.getClientArray()[ClientInex-1], VehicleManager.getElectricCars()[EletricCarLease-1]);

                LeaseList = addLeaseMechanism(LeaseList, newLease2);

                System.out.println("Contract sucessfully has been added!");

                LeaseCarTypeControl=false;
                LeaseCarControl =false;
                    break;
                }
                else {
                    System.out.println("This Vehicle is already leased!");
                    break;
                }

                case 3:

                if(VehicleManager.getDieselTrucks()==null){
                    System.out.println("No Diesel Truck has been registered yet!");
                    return;
                }

                VehicleManager.ListAllVehicles(VehicleManager.getDieselTrucks());

                System.out.print("Choose what vehicle does the Client want to lease:");
                int DieselTruckLease = input.nextInt();
                input.nextLine();

                if(VehicleManager.getDieselTrucks()[DieselTruckLease-1].VehicleLeaseStatus()==false){

                VehicleManager.getDieselTrucks()[DieselTruckLease-1].ModifyLeaseStatus(true); //Just noticed there's no point for this (taken care of by lease constructor)

                Lease newLease3 = new Lease(ClientManager.getClientArray()[ClientInex-1],VehicleManager.getDieselTrucks()[DieselTruckLease-1]);

                LeaseList = addLeaseMechanism(LeaseList, newLease3);

                System.out.println("Contract sucessfully has been added!");

                LeaseCarTypeControl=false;
                LeaseCarControl =false;
                    break;
                }
                else{
                    System.out.println("This Vehicle is already leased");
                    break;
                }

                case 4:

                if(VehicleManager.getElectricTrucks()==null){
                    System.out.println("No Electric Truck has been registered yet!");
                    return;
                }

                VehicleManager.ListAllVehicles(VehicleManager.getElectricTrucks());

                System.out.print("Choose what vehicle does the Client want to lease:");
                int ElectricTruckLease = input.nextInt();
                input.nextLine();

                if(VehicleManager.getElectricTrucks()[ElectricTruckLease-1].VehicleLeaseStatus()==false){

                VehicleManager.getElectricTrucks()[ElectricTruckLease-1].ModifyLeaseStatus(true); //Just noticed there's no point for this (taken care of by lease constructor)

                Lease newLease4 = new Lease(ClientManager.getClientArray()[ClientInex-1], VehicleManager.getElectricTrucks()[ElectricTruckLease-1]);

                LeaseList = addLeaseMechanism(LeaseList, newLease4);

                System.out.println("Contract sucessfully has been added!");

                LeaseCarTypeControl=false;
                LeaseCarControl =false;
                    break;}
                    else{
                        System.out.println("This Vehicle is already leased");
                        break;
                    }

                case 5:
                LeaseCarTypeControl=false;
                LeaseCarControl =false;
                    break;

                default: System.out.println("Option does not exist! Try again!");
                         LeaseCarControl =false;
            }
                }
            }
            else System.out.println("Option does not exist! Try again!");
                return;
          }
        }


}
