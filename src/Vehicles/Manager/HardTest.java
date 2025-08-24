package Vehicles.Manager;
import Driver.*;
import Vehicles.*;

/**
 * Utility class providing a predefined data set and demonstration routines
 * for manual testing of vehicle creation, equality, and copying features.
 * @author Ahmed Gara Ali
 * @version 1.0
 * @since 1.0
 */
public class HardTest {

    //Array of preset vehicle space of all types and all vehicle array
        public static Vehicle[] AllVehicles = new Vehicle[15];
        public static GasCar[] gasCars = new GasCar[5];
         public static ElectricCar[] elecCars = new ElectricCar[5];
        public static  ElectricTruck [] elecTrucks = new ElectricTruck[5];
        public static  DieselTruck [] dieselTrucks = new DieselTruck[5];
         public static Vehicle[][] Testing = new Vehicle[5][4];


         //This method sets all the objects in their respective array and in the all vehicles array
         /**
          * Populates the static arrays with sample objects (gas cars, electric cars, diesel & electric trucks).
          */
         public static void RecordSetter(){
        gasCars[0] = new GasCar("Benz","Rs",2020,4);
        gasCars[1] = new GasCar(gasCars[0]);
        gasCars[2] = new GasCar("Merco","r12",2020,4);

        elecCars[0] = new ElectricCar("Benz", "RELEC", 2020, 9, 204);
        elecCars[1] = new ElectricCar(elecCars[0]);
        elecCars[2] = new ElectricCar("Benz", "2DL", 2020, 9, 204);

        elecTrucks[0] = new ElectricTruck("Kls","Dwad",23,233,323);
        elecTrucks[1] = new ElectricTruck(elecTrucks[0]);
        elecTrucks[2] = new ElectricTruck("Kls","Dwa",23,2323,323);

        dieselTrucks[0] = new DieselTruck("Kls","Dwad",23,23233,323);
        dieselTrucks[1] = new DieselTruck(dieselTrucks[0]);
        dieselTrucks[2] =  new DieselTruck("Kls","Dw23ad",23,233,323);

        for (int i=0;i<3;i++){
        Testing[0][i]= gasCars[i];
        Testing[1][i]= elecCars[i];
        Testing[2][i]= elecTrucks[i];
        Testing[3][i]= dieselTrucks[i];    
    }

        AllVehicles[0]=Testing[0][0];
        AllVehicles[1]=Testing[0][1];
        AllVehicles[2]=Testing[0][2];

        AllVehicles[3]=Testing[1][0];
        AllVehicles[4]=Testing[1][1];
        AllVehicles[5]=Testing[1][2];

        AllVehicles[6]=Testing[2][0];
        AllVehicles[7]=Testing[2][1];
        AllVehicles[8]=Testing[2][2];

        AllVehicles[9]=Testing[3][0];
        AllVehicles[10]=Testing[3][1];
        AllVehicles[11]=Testing[3][2];
}
    //This method runs the methods we want to test (go to driver)
     /**
      * Runs demonstration prints for toString, equals, largest-truck finder and deep copy of electric trucks.
      */
     public static void HardTestRunner(){

        System.out.println("\nThe following is toString for all different types of vehicles:");
        for(int i=0;i<4;i++){

            for(int j=0;j<3;j++){
                System.out.println(Testing[i][j]);
            }
        }

        System.out.println("\nThe following is for equals for all different types of vehicles:\n");

        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                System.out.println(Testing[i][j].getClass());
                System.out.println(Testing[i][0].equals(Testing[i][j])+" ");
            }
            System.out.println();
        }

        System.out.println("The following is for demonstrating getLargestTruck() method:");
        
        System.out.println(RihaniVehicles.getLargestTruck(AllVehicles)+"\n");

        System.out.println("The following is for demonstrating copy constructor");
        

        ElectricTruck[] CopiedETrucks = RihaniVehicles.copyVehicles(elecTrucks);

        System.out.println("These are the original ETruck Array");
        for(int i=0;i<elecTrucks.length;i++){

            System.out.println(elecTrucks[i]+"\n");

        }

        System.out.println("This is the copied array");

        for(int i =0;i<CopiedETrucks.length;i++){
            System.out.println(CopiedETrucks[i]+"\n");

        }
        //Indeed 2 last object slots of the array are null (nothing inside yet)
        System.out.println();
    }
}
