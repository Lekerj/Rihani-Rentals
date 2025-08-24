package Vehicles.Manager;
import java.util.Scanner;
import Client.*;
import Driver.RihaniVehicles; // added for standardized menu

/**
 * Provides CRUD operations and listing features for Client entities via console menus.
 * Maintains an in-memory expandable array of clients.
 * @author Ahmed Gara Ali
 * @version 1.0
 * @since 1.0
 */

public class ClientManager {

    /** Shared scanner for client input. */
    public static Scanner input = new Scanner(System.in);
    /** Array holding all registered clients. */
    private static Client[] AllClients=null; //Array for All Clients

    /**
     * @return current array of clients (may be null)
     */
    public static Client[] getClientArray(){
        return AllClients;
    }
    /**
     * Main client management menu loop.
     */
    public static void ClientManagementMenu(){
        boolean ClientMenuControl=true;
        while(ClientMenuControl){
            RihaniVehicles.printMenu("Client Management","Select an action", new String[]{
                "Add a new Client",
                "Edit an existing Client",
                "Delete an existing Client",
                "Exit Client Menu"});
            System.out.print("Enter choice: ");
            int clientoption = input.nextInt();
            input.nextLine();
            switch(clientoption){
                case 1:
                    AllClients = addClient(AllClients);
                    break;
                case 2:
                    editClient();
                    break;
                case 3:
                    AllClients=deleteClient(AllClients);
                    break;
                case 4:
                    ClientMenuControl=false;
                    break;
                default: System.out.println("Invalid option.");
            }
        }
    }
    
    /**
     * Adds a client via interactive prompts and returns the new array.
     * @param AllClients1 existing clients
     * @return expanded array including new client
     */
    public static Client[] addClient(Client[] AllClients1){
    
        System.out.print("\nFill up the personal information of the client\n");
        System.out.println("Client Full Name:");
        String ClientFullName = input.nextLine();
        System.out.println("Client's Phone Number:");
        String ClientPhone = input.nextLine();
        System.out.println("Client Brith Date (d/m/y):");
        String ClientBirthDate = input.nextLine();
        System.out.println("Client Adress:");
        String ClientAdress = input.nextLine();
    
        Client newClient = new Client(ClientFullName, ClientPhone, ClientBirthDate, ClientAdress);
    
        if (AllClients1==null||AllClients1.length==0){

            Client[] newAllClients = new Client[1];
            newAllClients[0] = newClient;
            return newAllClients;
        }
        else {
        Client[] newAllClients = new Client[AllClients1.length+1];
    
        for(int i =0;i<AllClients1.length;i++){
    
            newAllClients[i]=AllClients1[i];
    
        }
    
        newAllClients[AllClients1.length] = newClient;
        System.out.println("Here is the updated list:\n");
            
        for(int i = 0;i<newAllClients.length;i++){
    
            System.out.println("Client "+(i+1)+":\n"+newAllClients[i]);
        }
        return newAllClients;
    }
    }
    
    /**
     * Prints all registered clients to console.
     */
    public static void DisplayClients(){
    
        if(AllClients==null || AllClients.length==0){
            System.out.println("No Clients has been added yet!");
            return;
        }
        else{
        for(int i = 0;i<AllClients.length;i++){
    
            System.out.println("Client "+(i+1)+":\n"+AllClients[i]);
        }
        System.out.println();
        }
    }
    /**
     * Interactive editor for a selected client.
     */
    public static void editClient(){
        if(AllClients==null||AllClients.length==0){System.out.println("Cannot edit client if no client is registered"); return;}
        DisplayClients();
        System.out.print("Which Client would you like to modify:");
        int ClientOption = input.nextInt();
        input.nextLine();
        if( ClientOption < 1 || ClientOption> AllClients.length){
            System.out.println("Invalid Option, Returning to menu");
            return;
        }
        boolean editClientControl = true;
        while(editClientControl){
            RihaniVehicles.printMenu("Edit Client","Select field to edit", new String[]{
                "Full Name",
                "Phone Number",
                "Birth Date",
                "Address",
                "Exit"});
            System.out.print("Enter choice: ");
            int ClientEditOption = input.nextInt();
            input.nextLine();
            switch(ClientEditOption){
                case 1:
                    System.out.print("New Full Name:");
                    String newName=input.nextLine();
                    AllClients[ClientOption-1].setClientFullName(newName);
                    System.out.println("Edit Successfully Done!");
                    DisplayClients();
                    break;
                case 2:
                    System.out.print("New Phone Number:");
                    String newPhone=input.nextLine();
                    AllClients[ClientOption-1].setClientPhone(newPhone);
                    System.out.println("Edit Successfully Done!");
                    DisplayClients();
                    break;
                case 3:
                    System.out.print("New Birth Date(d/m/y):");
                    String newBirthDate=input.nextLine();
                    AllClients[ClientOption-1].setClientBirthDate(newBirthDate);
                    System.out.println("Edit Successfully Done!");
                    DisplayClients();
                    break;
                case 4:
                    System.out.print("New Home Address:");
                    String newAdress=input.nextLine();
                    AllClients[ClientOption-1].setAdress(newAdress);
                    System.out.println("Edit Successfully Done!");
                    DisplayClients();
                    break;
                case 5:
                    editClientControl=false;
                    break;
                default: System.out.println("Invalid option.");
            }
        }
    }
    /**
     * Deletes a selected client creating a new array with one fewer element.
     * @param c current client array
     * @return reduced array or original if no deletion
     */
    public static Client[] deleteClient(Client[] c){
    
        if(c==null || c.length==0){
            System.out.println("No Client has been added yet!");
            return c;
        }
    
        DisplayClients();
        boolean deleteClientControl=true;
    
        while(deleteClientControl){
        
        System.out.print("Which Client would you like to delete:");
        int ClientDelete = input.nextInt();
        input.nextLine();
       
    
        if (ClientDelete<1||ClientDelete>c.length){
            System.out.println("Invalid option! Returning to menu");
            return c;
        }
    
    
        Client[] newC= new Client[c.length-1];
        
        int indexEditFollower = 0;
    
    
            for(int i =0;i<c.length;i++){
    
                if(i!=ClientDelete-1){
    
                    newC[indexEditFollower]=c[i];
                    indexEditFollower++;
                }
            }
            deleteClientControl =false;
    
            System.out.println("Here is the updated list:\n");
            
            for(int i = 0;i<newC.length;i++){
    
                System.out.println("Client "+(i+1)+":\n"+newC[i]);
            }
    
            return newC;
        }
      return c;  //this should never happen but it asks for a return by force
    }
    
    
}
