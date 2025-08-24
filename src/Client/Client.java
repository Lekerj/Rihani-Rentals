package Client;

/**
 * Represents a client (customer) that can lease vehicles.
 * Stores personal contact and identification attributes.
 * @author Ahmed Gara Ali
 * @version 1.0
 * @since 1.0
 */
public class Client {
    
    /** Full legal name. */
    private String ClientFullName;
    /** Phone number (raw string). */
    private  String ClientPhone;
    /** Birth date string (d/m/y). */
    private  String ClientBirthDate;
    /** Street address. */
    private  String Adress;
    /** Global client counter. */
    public static int numClients=0;

    /** Default constructor initializes fields to null. */
    public Client(){
        this.ClientFullName =null;
        this.ClientPhone = null;
        this.ClientBirthDate= null;
        this.Adress=null;
        numClients++;
    }

    /**
     * Parameterized constructor.
     * @param clientFullName full name
     * @param clientPhone phone number
     * @param clientBirthDate birth date d/m/y
     * @param adress address
     */
    public Client(String clientFullName, String clientPhone, String clientBirthDate, String adress) {
        ClientFullName = clientFullName;
        ClientPhone = clientPhone;
        ClientBirthDate = clientBirthDate;
        Adress = adress;
        numClients++;
    }

    /**
     * Copy constructor.
     * @param aClient client to copy
     */
    public Client(Client aClient){
        this.ClientFullName= aClient.ClientFullName;
        this.ClientBirthDate=aClient.ClientBirthDate;
        this.Adress=aClient.Adress;
        this.ClientPhone=aClient.ClientPhone;

    }

    /** @return full name */
    public String getClientFullName() {
        return ClientFullName;
    }

    /** @param clientFullName new full name */
    public void setClientFullName(String clientFullName) {
        ClientFullName = clientFullName;
    }

    /** @return phone */
    public String getClientPhone() {
        return ClientPhone;
    }

    /** @param clientPhone new phone */
    public void setClientPhone(String clientPhone) {
        ClientPhone = clientPhone;
    }

    /** @return birth date */
    public String getClientBirthDate() {
        return ClientBirthDate;
    }

    /** @param clientBirthDate new birth date */
    public void setClientBirthDate(String clientBirthDate) {
        ClientBirthDate = clientBirthDate;
    }

    /** @return address */
    public String getAdress() {
        return Adress;
    }

    /** @param adress new address */
    public void setAdress(String adress) {
        Adress = adress;
    }



    /**
     * Equality based on all stored attributes.
     * @param aClient other client
     * @return true if all attributes match
     */
    public boolean equals(Client aClient) {

        return (this.ClientPhone.equals(aClient.ClientPhone) && 
                this.ClientBirthDate.equals(aClient.ClientBirthDate)&&
                this.Adress.equals(aClient.Adress)&&
                this.ClientFullName.equals(aClient.ClientFullName));
    }

    /**
     * Builds multi-line string containing client data.
     * @return formatted client details
     */
    public String toString() {
        return "Full Name: " + ClientFullName + "\nPhone Number: " + ClientPhone + "\nBirth Date: "
                + ClientBirthDate + "\nAdress: " + Adress;
    }

}
