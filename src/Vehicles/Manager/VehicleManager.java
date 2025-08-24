package Vehicles.Manager;
import Vehicles.*;
import java.util.Scanner;
import Driver.RihaniVehicles; // added for standardized menus

/**
 * Manages creation, update, deletion, listing and auxiliary operations for all vehicle types.
 * Maintains separate arrays per subtype plus a unified registry.
 * @author Ahmed Gara Ali
 * @version 1.0
 * @since 1.0
 * @see Vehicles.Vehicle
 */
public class VehicleManager{

    // Arrays to store different types of vehicles
    /** Master registry of every vehicle instance. */
    private static Vehicle[] EveryVehicles=null; //Array for all Vehicles
    /** Gas cars inventory. */
    private static GasCar[] GasCars=null;
    /** Electric cars inventory. */
    private static ElectricCar[] ElectricCars=null;
    /** Electric trucks inventory. */
    private static ElectricTruck[] ElectricTrucks=null;
    /** Diesel trucks inventory. */
    private static DieselTruck[] DieselTrucks=null;
 
    /** Shared scanner for console input. */
    public static Scanner input = new Scanner(System.in);

    //Counters (increment only when created) might be useful in the future
    /** Total vehicle count. */
    public static int VehiclesCount=0;
    /** Gas car count. */
    public static int GasCarCount=0;
    /** Electric car count. */
    public static int EletricCarCount=0;
    /** Diesel truck count. */
    public static int DieselTruckCount=0;
    /** Electric truck count. */
    public static int EletricTruckCount=0;

//Getters for all the arrays
/** @return array containing every vehicle */
public static Vehicle[] getEveryVehicles() { return EveryVehicles; }
/** @return gas car array */
public static GasCar[] getGasCars() { return GasCars; }
/** @return electric car array */
public static ElectricCar[] getElectricCars() { return ElectricCars; }
/** @return electric truck array */
public static ElectricTruck[] getElectricTrucks() { return ElectricTrucks; }
/** @return diesel truck array */
public static DieselTruck[] getDieselTrucks() { return DieselTrucks; }

    /**
     * Vehicle management main menu loop.
     */
public static void VehicleMangementMenu(){
    boolean VehicleMangementControl=true;
    while(VehicleMangementControl){
        RihaniVehicles.printMenu("Vehicle Management","Select an action", new String[]{
            "Add a new Vehicle",
            "Delete an existing Vehicle",
            "Update an existing Vehicle",
            "List all Vehicles",
            "Exit Vehicle Menu"});
        System.out.print("Enter choice: ");
        switch(input.nextInt()){
            case 1:
                AddVehicletTypeMenu();
                break;
            case 2:
                DeleteVehicletTypeMenu();
                break;
            case 3:
                UpdateVehicletTypeMenu();
                break;
            case 4:
                ListAllVehicles(EveryVehicles);
                break;
            case 5:
                VehicleMangementControl=false;
                break;
            default: System.out.println("Invalid option.");
        }
    }
}
        /**
         * Add-vehicle submenu loop (creates new subtype instances based on user input).
         */
public static void AddVehicletTypeMenu(){
    boolean AddVehicleControl=true;
    while(AddVehicleControl){
        RihaniVehicles.printMenu("Add Vehicle","Choose vehicle type", new String[]{
            "Add a Gas Car",
            "Add an Electric Car",
            "Add a Diesel Truck",
            "Add an Electric Truck",
            "Exit Add Vehicle Menu"});
        System.out.print("Enter choice: ");
        int selection = input.nextInt();
        input.nextLine();
        switch(selection){

            case 1:

                System.out.println("What is the make (brand name) of the Car:");
                String GasCarBrand = input.nextLine();
                System.out.println("What is the model  of the Car:");
                String GasCarModel = input.nextLine();
                System.out.println("What is the year production of the Car:");
                int GasCarProdYear = input.nextInt();
                input.nextLine();
                System.out.println("What is the Maximum Passengers Count of the Car:");
                int GasCarMaxPassenger = input.nextInt();
                input.nextLine();

                //Creating new Vehicle and adding it to its own array and to all array and incrementing both counters
                GasCar newGasCar = new GasCar(GasCarBrand, GasCarModel, GasCarProdYear, GasCarMaxPassenger);

                
                GasCars = (GasCar[])addVehicle(newGasCar, GasCars);
                EveryVehicles = addVehicle(newGasCar, EveryVehicles);
              
                VehiclesCount++;
                GasCarCount++;

                break;
            case 2:

            System.out.println("What is the make (brand name) of the Car:");
            String ElecCarBrand = input.nextLine();
            System.out.println("What is the model  of the Car:");
            String ElecCarModel = input.nextLine();
            System.out.println("What is the year production of the Car:");
            int ElecCarProdYear = input.nextInt();
            input.nextLine();
            System.out.println("What is the Maximum Passengers Count of the Car:");
            int ElecCarMaxPassenger = input.nextInt();
            input.nextLine();
            System.out.println("What is the Maximum Kilometer Range (km) of the Electric Car:");
            double ElecCarKMRange = input.nextDouble();
            input.nextLine();

            //Creating new Vehicle and adding it to its own array and to all array and incrementing both counters
            ElectricCar newElectricCar = new ElectricCar(ElecCarBrand, ElecCarModel, ElecCarProdYear, ElecCarMaxPassenger, ElecCarKMRange);

            ElectricCars = (ElectricCar[])addVehicle(newElectricCar, ElectricCars);
            EveryVehicles = addVehicle(newElectricCar, EveryVehicles);

            VehiclesCount++;
            EletricCarCount++;

                break;
            case 3:

            System.out.println("What is the make (brand name) of the Truck:");
            String DieselBrand = input.nextLine();
            System.out.println("What is the model of the Truck:");
            String DieselModel = input.nextLine();
            System.out.println("What is the year production of the Truck:");
            int DieselProdYear = input.nextInt();
            input.nextLine();
            System.out.println("What is the Maximum Weight Capacity (kg) of the Truck:");
            double DieselMaxCap = input.nextDouble();
            input.nextLine();
            System.out.println("What is the Maximum Fuel Capacity (L) of the Diesel Truck:");
            double DieselFuelCap = input.nextDouble();
            input.nextLine();

            //Creating new Vehicle and adding it to its own array and to all array and incrementing both counters
            DieselTruck newDieselTruck = new DieselTruck(DieselBrand, DieselModel, DieselProdYear, DieselMaxCap, DieselFuelCap);

            DieselTrucks = (DieselTruck[])addVehicle(newDieselTruck, DieselTrucks);
            EveryVehicles = addVehicle(newDieselTruck, EveryVehicles);

            VehiclesCount++;
            DieselTruckCount++;

                break;
            case 4:
            
            System.out.println("What is the make (brand name) of the Truck:");
            String ElecTruckBrand = input.nextLine();
            System.out.println("What is the model of the Truck:");
            String ElecTruckModel = input.nextLine();
            System.out.println("What is the year production of the Truck:");
            int ElecTruckProdYear = input.nextInt();
            input.nextLine();
            System.out.println("What is the Maximum Weight Capacity (kg) of the Truck:");
            double ElecTruckMaxCap = input.nextDouble();
            input.nextLine();
            System.out.println("What is the Maximum Kilometer Range (km) of the Eletric Truck:");
            double ElecTruckKMRange = input.nextDouble();
            input.nextLine();

            //Creating new Vehicle and adding it to its own array and to all array and incrementing both counters
            ElectricTruck newElectricTruck = new ElectricTruck(ElecTruckBrand, ElecTruckModel, ElecTruckProdYear, ElecTruckMaxCap, ElecTruckKMRange);

            ElectricTrucks = (ElectricTruck[])addVehicle(newElectricTruck, ElectricTrucks);
            EveryVehicles = addVehicle(newElectricTruck, EveryVehicles);

            EletricTruckCount++;
            VehiclesCount++;

                break;
            case 5: 
                 AddVehicleControl=false;
                break;
            default: System.out.println("Invalid option.");
        }
    }
}

    /**
     * Delete-vehicle submenu loop (removes instance from subtype and global arrays).
     */
public static void DeleteVehicletTypeMenu(){
    boolean DeleteVehicleControl=true;
    while(DeleteVehicleControl){

        RihaniVehicles.printMenu("Delete Vehicle","Choose vehicle type", new String[]{
            "Delete a Gas Car",
            "Delete an Electric Car",
            "Delete a Diesel Truck",
            "Delete an Electric Truck",
            "Exit Delete Vehicle Menu"});
        System.out.print("Enter choice: ");

        switch(input.nextInt()){

            case 1:
           GasCars = (GasCar[])DeleteVehicle(GasCars);
                break;
            case 2:
           ElectricCars = (ElectricCar[])DeleteVehicle(ElectricCars);
                break;
            case 3:
            DieselTrucks = (DieselTruck[])DeleteVehicle(DieselTrucks);
                break;
            case 4:
            ElectricTrucks = (ElectricTruck[])DeleteVehicle(ElectricTrucks);
                break;
            case 5: DeleteVehicleControl=false;
                break;
            default: System.out.println("Invalid option.");

        }
    }
}


    /**
     * Update-vehicle submenu loop (dispatch by subtype).
     */
public static void UpdateVehicletTypeMenu(){
    boolean UpdateVehicleControl=true;
    while(UpdateVehicleControl){

        RihaniVehicles.printMenu("Update Vehicle","Choose vehicle type", new String[]{
            "Update a Gas Car",
            "Update an Electric Car",
            "Update a Diesel Truck",
            "Update an Electric Truck",
            "Exit Update Vehicle Menu"});
        System.out.print("Enter choice: ");

        switch(input.nextInt()){

            case 1:
            GasCarUpdator();
                break;
            case 2:
            ElectricCarUpdator();
                break;
            case 3:
            DieselUpdator();
                break;
            case 4:
            ElectricTruckUpdator();
                break;
            case 5: 
            UpdateVehicleControl=false;
                break;
            default: System.out.println("Invalid option.");

        }
    }
}
// Simplified and corrected UpdateCoordinator: index is zero-based now.
    /**
     * Applies a specific update action to a selected vehicle.
     * @param index zero-based index inside provided array
     * @param option update action number
     * @param v target array
     */
public static void UpdateCoordinator(int index,int option,Vehicle[] v){

    if (v == null || v.length == 0) { 
        System.out.println("No vehicles available to update!");
        return;
    }
    if(index<0 || index>=v.length){
        System.out.println("Invalid vehicle selection.");
        return;
    }
    Vehicle target = v[index];

    switch(option){
        case 1: // make
            System.out.println("New Make (Brand):");
            target.setMake(input.nextLine());
            break;
        case 2: // model
            System.out.println("New Model:");
            target.setModel(input.nextLine());
            break;
        case 3: // production year
            System.out.println("New Production Year:");
            int year = input.nextInt();
            input.nextLine();
            target.setProdyear(year);
            break;
        case 4: // capacity (passenger or weight)
            if(target instanceof Car){
                System.out.println("New Maximum Passenger Capacity:");
                int p = input.nextInt();
                input.nextLine();
                if(target instanceof GasCar gc){ gc.setPassengerCap(p); }
                else if(target instanceof ElectricCar ec){ ec.setPassengerCap(p);}
            } else if (target instanceof Truck){
                System.out.println("New Maximum Weight Capacity (kg):");
                double w = input.nextDouble();
                input.nextLine();
                if(target instanceof DieselTruck dt){ dt.setWeightCap(w);} else if(target instanceof ElectricTruck et){ et.setWeightCap(w);}
            } else {
                System.out.println("Unsupported vehicle for option 4.");
            }
            break;
        case 5: // range or fuel
            if(target instanceof ElectricCar ec){
                System.out.println("New Maximum KM Range (km):");
                double km = input.nextDouble();
                input.nextLine();
                ec.setcKMRange(km);
            } else if(target instanceof ElectricTruck et){
                System.out.println("New Maximum KM Range (km):");
                double km = input.nextDouble();
                input.nextLine();
                et.setKmRange(km);
            } else if(target instanceof DieselTruck dt){
                System.out.println("New Maximum Fuel Capacity (L):");
                double fuel = input.nextDouble();
                input.nextLine();
                dt.setFuelCap(fuel);
            } else {
                System.out.println("Option 5 not applicable.");
            }
            break;
        default:
            System.out.println("Unknown update option.");
    }
}

/**
 * Interactive updater for gas cars.
 */
public static void GasCarUpdator(){
    ListAllVehicles(GasCars);
    if(GasCars==null) return;
    System.out.print("Choose the Gas Car: ");
    int choice = input.nextInt();
    input.nextLine();
    if(choice<1 || choice>GasCars.length){ System.out.println("Invalid selection."); return; }
    boolean loop=true;
    while(loop){
        RihaniVehicles.printMenu("Update Gas Car","Select field", new String[]{
            "Make (Brand)",
            "Model",
            "Production Year",
            "Passenger Capacity",
            "Exit"});
        System.out.print("Enter choice: ");
        int o= input.nextInt();
        input.nextLine();
        if(o==5){loop=false; break;}
        UpdateCoordinator(choice-1,o, GasCars);
    }
}
//Menu when user wants to update a electric car
public static void ElectricCarUpdator(){
    ListAllVehicles(ElectricCars);
    if(ElectricCars==null) return;
    System.out.print("Choose the Electric Car: ");
    int choice = input.nextInt();
    input.nextLine();
    if(choice<1 || choice>ElectricCars.length){ System.out.println("Invalid selection."); return; }
    boolean loop=true;
    while(loop){
        RihaniVehicles.printMenu("Update Electric Car","Select field", new String[]{
            "Make (Brand)",
            "Model",
            "Production Year",
            "Passenger Capacity",
            "KM Range",
            "Exit"});
        System.out.print("Enter choice: ");
        int o= input.nextInt();
        input.nextLine();
        if(o==6){loop=false; break;}
        UpdateCoordinator(choice-1,o, ElectricCars);
    }
}
//Menu when user wants to update a diesel truck
public static void DieselUpdator(){
    ListAllVehicles(DieselTrucks);
    if(DieselTrucks==null) return;
    System.out.print("Choose the Diesel Truck: ");
    int choice = input.nextInt();
    input.nextLine();
    if(choice<1 || choice>DieselTrucks.length){ System.out.println("Invalid selection."); return; }
    boolean loop=true;
    while(loop){
        RihaniVehicles.printMenu("Update Diesel Truck","Select field", new String[]{
            "Make (Brand)",
            "Model",
            "Production Year",
            "Weight Capacity",
            "Fuel Capacity",
            "Exit"});
        System.out.print("Enter choice: ");
        int o= input.nextInt();
        input.nextLine();
        if(o==6){loop=false; break;}
        UpdateCoordinator(choice-1,o,DieselTrucks);
    }
}
//Menu when user wants to update a electric truck
public static void ElectricTruckUpdator(){
    ListAllVehicles(ElectricTrucks);
    if(ElectricTrucks==null) return;
    System.out.print("Choose the Electric Truck: ");
    int choice = input.nextInt();
    input.nextLine();
    if(choice<1 || choice>ElectricTrucks.length){ System.out.println("Invalid selection."); return; }
    boolean loop=true;
    while(loop){
        RihaniVehicles.printMenu("Update Electric Truck","Select field", new String[]{
            "Make (Brand)",
            "Model",
            "Production Year",
            "Weight Capacity",
            "KM Range",
            "Exit"});
        System.out.print("Enter choice: ");
        int o= input.nextInt();
        input.nextLine();
        if(o==6){loop=false; break;}
        UpdateCoordinator(choice-1,o,ElectricTrucks);
    }
}

    //Method that adds vehicles and creates a new space in a new array and assigns last slot that vehicle
    /**
     * Adds a vehicle into a (possibly null) typed array, returning the new grown array.
     * @param v vehicle to add
     * @param vArray existing array (may be null)
     * @return new array including vehicle
     */
public static Vehicle[] addVehicle(Vehicle v, Vehicle[] vArray) {
    
    if(vArray==null){

        if (v instanceof GasCar) {
            GasCar[] newArray = new GasCar[1];
            newArray[0] = (GasCar) v;
            return newArray;
        } else if (v instanceof ElectricCar) {
            ElectricCar[] newArray = new ElectricCar[1];
            newArray[0] = (ElectricCar) v;
            return newArray;
        } else if (v instanceof DieselTruck) {
            DieselTruck[] newArray = new DieselTruck[1];
            newArray[0] = (DieselTruck) v;
            return newArray;
        } else if (v instanceof ElectricTruck) {
            ElectricTruck[] newArray = new ElectricTruck[1];
            newArray[0] = (ElectricTruck) v;
            return newArray;
        } else {
            Vehicle[] newArray = new Vehicle[1];
            newArray[0] = v;
            return newArray;
        }
    }

    else if(vArray instanceof GasCar[] && v instanceof GasCar){

        GasCar[] newGasCarArray = new GasCar[vArray.length+1];

        for(int i =0;i<vArray.length;i++){

            newGasCarArray[i]=(GasCar)vArray[i];
        }

        newGasCarArray[vArray.length]=(GasCar)v;

        return newGasCarArray; //NOTE MUST CAST WHEN ASSINGING BECAUSE IT IS ALWAYS RETURN TYPE VEHICLE[]
    }

    else if(vArray instanceof ElectricCar[] && v instanceof ElectricCar){

        ElectricCar[] newElectricCarArray = new ElectricCar[vArray.length+1];

        for(int i =0;i<vArray.length;i++){

            newElectricCarArray[i]=(ElectricCar)vArray[i];
        }

        newElectricCarArray[vArray.length]=(ElectricCar)v;

        return newElectricCarArray; //NOTE MUST CAST WHEN ASSINGING BECAUSE IT IS ALWAYS RETURN TYPE VEHICLE[]
    }

    else if(vArray instanceof DieselTruck[] && v instanceof DieselTruck){

        DieselTruck[] newDiesTruckArray = new DieselTruck[vArray.length+1];

        for(int i =0;i<vArray.length;i++){

            newDiesTruckArray[i]=(DieselTruck)vArray[i];
        }

        newDiesTruckArray[vArray.length]=(DieselTruck)v;

        return newDiesTruckArray; //NOTE MUST CAST WHEN ASSINGING BECAUSE IT IS ALWAYS RETURN TYPE VEHICLE[]
    }

    else if(vArray instanceof ElectricTruck[] && v instanceof ElectricTruck){

        ElectricTruck[] newElecTruckArray = new ElectricTruck[vArray.length+1];

        for(int i =0;i<vArray.length;i++){

            newElecTruckArray[i]=(ElectricTruck)vArray[i];
        }

        newElecTruckArray[vArray.length]=(ElectricTruck)v;

        return newElecTruckArray; //NOTE MUST CAST WHEN ASSINGING BECAUSE IT IS ALWAYS RETURN TYPE VEHICLE[]
    }

    else {

        Vehicle[] newAllVehicles = new Vehicle[vArray.length+1];

        for(int i=0;i<vArray.length;i++){

            newAllVehicles[i]=vArray[i];
        }

        newAllVehicles[vArray.length]=v;

        return newAllVehicles;
        
    }
}
//Method that deletes vehicles 
    /**
     * Removes a selected vehicle from a subtype array and global registry.
     * @param v subtype array
     * @return new reduced array (or original if none removed)
     */
public static Vehicle[] DeleteVehicle(Vehicle[] v) {
   
    if(v==null || v.length==0){
        System.out.println("No vehicles available to delete!");
    return v;
}
    System.out.println("Listing Vehicles...");
    ListAllVehicles(v);
    boolean DeleteVehicleControl =true;
    
    while(DeleteVehicleControl){
        System.out.print("\nSelect which Vehicle do you want to remove <Type a number and press Enter>: ");
        int deleteCandidate = input.nextInt();
        input.nextLine();

      if(deleteCandidate<=v.length && deleteCandidate>0){

        Vehicle ToRemoveVehicle = v[deleteCandidate-1];

        Vehicle[] RemovedArray = new Vehicle[v.length-1];
    
        int indexfollower=0;

        for(int i=0;i<v.length;i++){

            if(i != deleteCandidate-1){
                RemovedArray[indexfollower] = v[i]; 
                indexfollower++;
             }
         }
        DeleteVehicleControl=false;
        // Remove from global inventory BEFORE replacing category array reference
        EveryVehicles = RemoveFromAll(ToRemoveVehicle, EveryVehicles);
        // decrement counters
        VehiclesCount--;
        if(ToRemoveVehicle instanceof GasCar) GasCarCount--; else if(ToRemoveVehicle instanceof ElectricCar) EletricCarCount--; else if(ToRemoveVehicle instanceof DieselTruck) DieselTruckCount--; else if(ToRemoveVehicle instanceof ElectricTruck) EletricTruckCount--;
        return RemovedArray;
        }
        else{
        System.out.println("Option does not exist! Try again!");
        }
    }
    return v;
}

//Method to remove a vehicle for the array that has all vehicles 
    /**
     * Removes a vehicle reference from the global registry array.
     * @param v vehicle to remove
     * @param all global array
     * @return new global array without vehicle (or original if not found)
     */
public static Vehicle[] RemoveFromAll(Vehicle v,Vehicle[] all){

    if(all==null || v==null || all.length ==0){
        System.out.println("No vehicles available to delete in global inventory!");
        return all;
    }

    Vehicle[] newEveryVehicles = new Vehicle[all.length-1];
    int indexFollower = 0;
    boolean found =false;

        for(int i=0;i<all.length;i++){

            if(!found && all[i]==v){
                found=true;
                continue;
            }
            if(indexFollower<newEveryVehicles.length){
                newEveryVehicles[indexFollower] = all[i];
                indexFollower++;
            }
        }
        if(!found){
            System.out.println("Vehicle not found in global inventory (no removal).");
            return all; // unchanged
        }
        return newEveryVehicles;
}

//Lists all vehicles in the array 
    /**
     * Prints all vehicles in provided array to console.
     * @param v array to list
     */
public static void ListAllVehicles(Vehicle[] v) {
    
    if (v == null || v.length == 0) {
        System.out.println("No Vehicle has been added to the inventory yet!");
        return;
    }

    for (int i = 0; i < v.length; i++) {
        if (v[i] != null) {
            System.out.println("Vehicle "+(i+1)+":\n"+v[i]);
        }
        else {
            System.out.println("Vehicle "+(i+1)+" doesn't exist.");
        }   
    }
    System.out.println();
}


}