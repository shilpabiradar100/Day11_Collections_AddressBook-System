
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.SortedMap;
public class AddressBooking_Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("---Welcome To The Address Book Storing System---");
        AddressBookFeatures contact = new AddressBookFeatures();

        int in;
        do {
            System.out.println("Press 0 to add contact\nPress 1 for edit\nPress 2 for delete\nPress 4 for display\nPress 5 to Close");
            in = sc.nextInt();
            switch (in) {

                case 0: {

                    System.out.println("How Many Contacts You Want To Store?");
                    int input = sc.nextInt();

                    for (int i = 0; i < input; i++) {

                        contact.addNew();

                    }
                    break;
                }



                case 1: {

                    System.out.println("Enter Your PhoneNumber For Confirmation : ");
                    long phoneNumber = sc.nextLong();
                    boolean updated = contact.editContact(phoneNumber);
                    if (updated) {
                        System.out.println("Contact Updated.");
                    } else {
                        System.out.println("Contact not found");
                    }
                    break;
                }

                case 2:{

                    System.out.println("Enter Your PhoneNumber For Confirmation : ");
                    long phoneNumber = sc.nextLong();
                    boolean updated = contact.deleteByPhoneNumber(phoneNumber);
                    if (updated) {
                        System.out.println("Contact Deleted.");
                    } else {
                        System.out.println("Contact not found");
                    }
                    break;
                }

                case 4:{

                    contact.displayContacts();
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


class AddressBookFeatures {

    int size;
    ContactStoring[] multipleContacts = new ContactStoring[150];
    ContactStoring contact;

    Scanner sc = new Scanner(System.in);

    public void addNew() {

        //Scanner sc = new Scanner(System.in);

        System.out.println("Enter First Name");
        String firstName = sc.next();

        System.out.println("Enter The Last Name");
        String lastName = sc.next();

        //System.out.println("Enter Your Address");
        //String address = sc.nextLine();

        System.out.println("Enter Your City");
        String city = sc.next();

        System.out.println("Enter Your State");
        String state = sc.next();

        System.out.println("Enter Pin Number");
        int zip = sc.nextInt();

        System.out.println("Enter Your Phone Number");
        long phoneNumber = sc.nextLong();

        System.out.println("Enter Your Email Address");
        String email = sc.next();

        contact = new ContactStoring(firstName, lastName,  city, state, zip, phoneNumber, email);
        multipleContacts[size++] = contact;
    }

    public boolean editContact(long phoneNumber) {

        for (int i = 0; i < multipleContacts.length; i++) {
            if (multipleContacts[i] != null && multipleContacts[i].getPhoneNumber() == phoneNumber ) {

                System.out.println("Enter First Name");
                String firstName = sc.next();

                System.out.println("Enter last Name");
                String lastName = sc.next();

                System.out.println("Enter Your City");
                String city = sc.next();

                System.out.println("Enter Your State");
                String state = sc.next();

                System.out.println("Enter Your Pin Number");
                int zip = sc.nextInt();

                System.out.println("Enter Your Email");
                String email = sc.next();

                multipleContacts[i].setFirstName(firstName);
                multipleContacts[i].setLastName(lastName);
                multipleContacts[i].setCity(city);
                multipleContacts[i].setState(state);
                multipleContacts[i].setZip(zip);
                multipleContacts[i].setEmail(email);
                return true;
            }
        }
        return false;
    }

    public boolean deleteByPhoneNumber(long phoneNumber) {

        for (int i = 0; i < multipleContacts.length; i++) {
            if (multipleContacts[i] != null && multipleContacts[i].getPhoneNumber() == phoneNumber ) {
                for (int j = i; j < multipleContacts.length - 2; j++) {
                    multipleContacts[j] = multipleContacts[j + 1];
                }
                return true;
            }

        }
        return false;
    }

    public void displayContacts() {

        for (int i = 0; i < multipleContacts.length; i++) {
            if (multipleContacts[i] != null) {
                System.out.println(multipleContacts[i]);
            }

        }
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


    public ContactStoring(String firstName, String lastName,  String city, String state, int zip, long phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        //this.address = address;
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
