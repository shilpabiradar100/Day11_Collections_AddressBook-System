
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.SortedMap;
public class AddressBooking_Main {
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);

        System.out.println("---Welcome To The Address Book Storing System---");
        AddressBookFeatures contact = new AddressBookFeatures();
        contact.addNew();
        contact.displayContacts();
        System.out.println("Do You Want To Edit The Contact");
        char in = sc.next().charAt(0);
        if (in == 'Y' || in == 'y'){
            contact.editContact();
        }
        else {
            System.out.println("Thank You for using the address book service");
        }

    }

}

class AddressBookFeatures{
    ContactStoring contact;
    public void addNew(){

        Scanner sc = new Scanner(System.in);
        Scanner gh = new Scanner(System.in);

        System.out.println("Enter First Name");
        String firstName = sc.nextLine();

        System.out.println("Enter The Last Name");
        String lastName = sc.nextLine();

        System.out.println("Enter Your Address");
        String address = sc.nextLine();

        System.out.println("Enter Your City");
        String city = sc.nextLine();

        System.out.println("Enter Your State");
        String state = sc.nextLine();

        System.out.println("Enter Pin Number");
        int zip = sc.nextInt();

        System.out.println("Enter Your Phone Number");
        long phoneNumber = sc.nextLong();

        System.out.println("Enter Your Email Address");
        String email = gh.nextLine();

        contact = new ContactStoring(firstName,lastName,address,city,state,zip,phoneNumber,email);
    }

    public void editContact(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Name To Edit");
        String input = sc.nextLine();

        if(input.equalsIgnoreCase(contact.getFirstName())){
            addNew();
            System.out.println("Contact After Editing");
            displayContacts();
        }
        else {
            System.out.println("Input Not Matching");
            editContact();
        }
    }

    public void displayContacts(){

        System.out.println(contact);

    }
}

class ContactStoring{
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private long phoneNumber;
    private String email;

    public ContactStoring(String firstName, String lastName, String address, String city, String state, int zip, long phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contact:- {" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
