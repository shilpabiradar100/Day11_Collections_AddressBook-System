
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.SortedMap;
public class AddressBooking_Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("---Welcome To The Address Book Storing System---");
        AddressBookFeatures contact = new AddressBookFeatures();
        //contact.addNew();
        //contact.displayContacts();
        int in;
        do {
            System.out.println("Press 0 to add contact\nPress 1 for edit\nPress 2 for delete\nPress 5 to Close");
            in = sc.nextInt();
            switch (in) {

                case 0:{

                    contact.addNew();
                    contact.displayContacts();
                    break;

                }

                case 1: {

                    contact.editContact();
                    break;
                }

                case 2:{

                    contact.deleteByName();
                    break;
                }

                case 5:{

                    System.out.println("Application Closing || Thank You For Using Address Book Service");
                    break;
                }

                default:
                    System.out.println("Please Enter The Correct Choice");
                    break;
            }
        } while(in != 5);
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

    public void deleteByName(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The FirstName");
        String input = sc.nextLine();
        if(input.equalsIgnoreCase(contact.getFirstName())){
            contact = null;
            System.out.println("The Contact is Deleted Successfully");
            displayContacts();
            System.out.println("The Address Book is Empty");
        }
        else{
            System.out.println("Input Does Not Match With the Contact");
            deleteByName();
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
