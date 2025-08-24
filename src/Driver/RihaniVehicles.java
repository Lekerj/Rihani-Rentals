package Driver;

import java.util.Scanner;
import Vehicles.Manager.*;
import Vehicles.*;

/**
 * Entry point and user-interface layer for the Rihani Vehicles Management console application.
 * Provides standardized banner / menu rendering helpers reused by manager classes and coordinates navigation.
 * @author Ahmed Gara Ali
 * @version 1.0
 * @since 1.0
 * @see Vehicles.Manager.VehicleManager
 */
public class RihaniVehicles {

   public static Scanner input = new Scanner(System.in);
   private static final int MENU_WIDTH = 80;

    /**
     * Application bootstrap: prints welcome banner then processes initial user selection.
     * @param args command line arguments (unused)
     */
    public static void main(String[] args){
        displayWelcomeMessage(); //Display welcome message
        boolean firstPrompt=true;
        while(firstPrompt){
            printMenu("Startup Menu","Hello User, would you like to:", new String[]{
                "Hard-coded Scenario for testing",
                "Go to main menu",
                "Exit program"
            });
            System.out.print("Enter choice: ");
            int choice = input.nextInt();
            switch(choice){
                case 1:
                    HardTest.RecordSetter();
                    HardTest.HardTestRunner();
                    firstPrompt=false;
                    break;
                case 2:
                    displayWelcomeMessage();
                    displayMenu();
                    break;
                case 3:
                    firstPrompt=false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        input.close(); //Close the scanner
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Standardized menu helpers
/** Prints a full-width separator line used by menus. */
private static void printLine(){ System.out.println("".repeat(0)+"*".repeat(MENU_WIDTH)); }
/**
 * Centers arbitrary text inside the menu frame.
 * @param text content to center
 * @return framed centered line
 */
private static String center(String text){
    if(text==null) text="";
    int inner = MENU_WIDTH - 2;
    if(text.length()>inner) text = text.substring(0, inner);
    int left = (inner - text.length())/2;
    int right = inner - text.length() - left;
    return "|" + " ".repeat(left) + text + " ".repeat(right) + "|";
}
 /**
 * Builds a single option line (numbered) for a menu.
 * @param idx 1-based index
 * @param option option text
 * @return formatted line
 */
private static String optionLine(int idx,String option){
    String prefix = String.format("%2d >> ", idx);
    String text = prefix + option;
    int inner = MENU_WIDTH - 2;
    if(text.length()>inner) text=text.substring(0, inner);
    StringBuilder sb = new StringBuilder(text);
    while(sb.length()<inner) sb.append(' ');
    return "|"+sb+"|";
}
/**
 * Renders a standardized menu with title, optional header, and numbered options.
 * @param title menu title
 * @param header optional header/question (may be null)
 * @param options ordered list of options
 */
public static void printMenu(String title, String header, String[] options){
    System.out.println();
    printLine();
    System.out.println(center(title));
    printLine();
    if(header!=null && !header.isBlank()){
        System.out.println(center(header));
        printLine();
    }
    for(int i=0;i<options.length;i++){
        System.out.println(optionLine(i+1, options[i]));
    }
    printLine();
}
/**
 * Prints a decorative banner containing a centered title.
 * @param title banner title
 */
public static void printBanner(String title){
    System.out.println();
    printLine();
    System.out.println(center(title));
    printLine();
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Method to display a welcome message
/** Displays the welcome banner for the application. */
public static void displayWelcomeMessage() { printBanner("Welcome to Rihani Vehicles Management Service"); }

/**
 * Main navigation menu loop for the application.
 */
public static void displayMenu() {
    boolean mainMenu=true;
    while(mainMenu){
        printMenu("Main Menu","What would you like to do?", new String[]{
            "Vehicle Management Menu",
            "Client Management Menu",
            "Lease Management Menu",
            "Additional Operations",
            "Exit"
        });
        System.out.print("Enter choice: ");
        int opt = input.nextInt();
        switch(opt){
            case 1:
                input.nextLine();
                VehicleManager.VehicleMangementMenu();
                break;
            case 2:
                input.nextLine();
                ClientManager.ClientManagementMenu();
                break;
            case 3:
                input.nextLine();
                LeaseManager.LeaseManagementMenu();
                break;
            case 4:
                input.nextLine();
                AdditionalOperationsMenu();
                break;
            case 5:
                input.nextLine();
                System.out.println("Thank you for using Rihani Vehicles! Goodbye!");
                mainMenu=false;
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Additional operations menu
/**
 * Additional operations menu (utility features outside CRUD core).
 */
public static void AdditionalOperationsMenu(){
    boolean loop=true;
    while(loop){
        printMenu("Additional Operations","Select an action", new String[]{
            "Display Truck with Largest Capacity",
            "Copy Electric Truck Inventory",
            "Exit"
        });
        System.out.print("Enter choice: ");
        int choice = input.nextInt();
        switch(choice){
            case 1:
                System.out.println("Largest Truck:\n"+getLargestTruck(VehicleManager.getEveryVehicles()));
                break;
            case 2:
                ElectricTruck[] copy = copyVehicles(VehicleManager.getElectricTrucks());
                System.out.println("Original Inventory:");
                ElectricTruck[] orig = VehicleManager.getElectricTrucks();
                if(orig!=null) for(ElectricTruck t: orig) System.out.println(t);
                System.out.println("Copied Inventory:");
                if(copy!=null) for(ElectricTruck t: copy) System.out.println(t);
                break;
            case 3:
                loop=false;
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}
//Method that checks for the largest truck and returns it
/**
 * Determine the truck (diesel or electric) with greatest weight capacity.
 * @param v vehicle array to scan (may contain heterogeneous types)
 * @return largest-capacity Truck or null
 * @see Vehicles.Truck
 */
public static Truck getLargestTruck(Vehicle[] v) {
    if(v==null || v.length==0){
        System.out.println("No vehicles in inventory.");
        return null;
    }
    Truck r = null;

    for (Vehicle vehicle : v) {
        if (vehicle instanceof ElectricTruck et) {
            if (r == null || et.getWeightCap() > r.getWeightCap()) r = et;
        } else if (vehicle instanceof DieselTruck dt) {
            if (r == null || dt.getWeightCap() > r.getWeightCap()) r = dt;
        }
    }

    if (r == null) { System.out.println("No truck found, returning null! (ERROR!)"); }

    return r;
}
//Method that copies all elements of electric truck and returns a new array
/**
 * Deep-copies an array of electric trucks via copy constructor.
 * @param v source array (may be null)
 * @return new array with cloned elements or null
 */
public static ElectricTruck[] copyVehicles(ElectricTruck[] v){
        if(v==null) return null;
        ElectricTruck[] r = new ElectricTruck[v.length];
        for(int i=0;i<v.length;i++) if(v[i]!=null) r[i]=new ElectricTruck(v[i]);
        return r;
}
}
