

import java.util.*;

public class AddressBooking_Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



        System.out.println("---Welcome To The Address Book Storing System---");
        AddressBookFeatures contact = new AddressBookFeatures();


        int in;
        do {

            System.out.println("-->>Press 0 to Add AddressBooks<<--" +
                    "\n-->>Press 1 To Edit Contacts<<--" +
                    "\n-->>Press 2 To Delete Contacts<<--\n-->>Press 3 To Delete Address Book<<--" +
                    "\n-->>Press 4 To Display The Address Books<<--" +
                    "\n-->>Press 5 To Close The Program<<--");
            System.out.println();
            System.out.print("YOUR INPUT --->> ");
            in = sc.nextInt();
            switch (in) {

                case 0: {

                    contact.addNew();
                    break;

                }



                case 1: {

                    System.out.print("Enter The Address Book Name: ");
                    String userInput = sc.next();

                    System.out.print("Enter Your PhoneNumber For Confirmation: ");
                    long phoneNumber = sc.nextLong();
                    boolean updated = contact.editContact(phoneNumber,userInput);

                    if (updated) {
                        System.out.println("---Contact Updated---");
                    } else {
                        System.out.println("---Contact not found---");
                    }
                    break;
                }

                case 2:{

                    System.out.print("Enter The Address Book Name: ");
                    String userInput = sc.next();

                    System.out.print("Enter Your PhoneNumber For Confirmation : ");
                    long phoneNumber = sc.nextLong();
                    boolean updated = contact.deleteByNumber(phoneNumber,userInput);
                    if (updated) {
                        System.out.println("---Contact Deleted---");
                    } else {
                        System.out.println("---Contact not found---");
                    }
                    break;
                }

                case 4:{

                    contact.displayContacts();
                    break;

                }

                case 5:{

                    System.out.println("--->Application Closing || Thank You For Using Address Book Service<---");
                    break;
                }

                case 3:{

                    System.out.print("Enter The Address Book Name: ");
                    String userInput = sc.next();
                    boolean updated = contact.deleteAddressBook(userInput);
                    if (updated){
                        System.out.println("---Address Book Deleted---");
                    }
                    else{
                        System.out.println("---Address Book Not Found---");
                    }
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


    List<ContactStoring> info = new LinkedList<>();

    HashMap<String, ArrayList> multipleAddressBook = new HashMap<>();

    ContactStoring contact;


    Scanner sc = new Scanner(System.in);

    public void addNew() {

        ArrayList<ContactStoring> temp = new ArrayList<>();

        System.out.print("Enter AddressBook Name : ");
        String input2 = sc.next();

        if(multipleAddressBook.containsKey(input2)){
            System.out.println("-----Address Book Already Exists-----");
        }
        else{

            System.out.print("How Many Contacts You Want To Store? -->> ");
            int userInput = sc.nextInt();
            for(int i =0 ; i < userInput; i++) {

                System.out.print("Enter First Name : ");
                String firstName = sc.next();


                System.out.print("Enter The Last Name : ");
                String lastName = sc.next();

                System.out.print("Enter Your City : ");
                String city = sc.next();

                System.out.print("Enter Your State : ");
                String state = sc.next();

                System.out.print("Enter Pin Number : ");
                int zip = sc.nextInt();

                System.out.print("Enter Your Phone Number : ");
                long phoneNumber = sc.nextLong();

                System.out.print("Enter Your Email Address : ");
                String email = sc.next();


                contact = new ContactStoring(firstName, lastName, city, state, zip, phoneNumber, email);

                info.add(contact);

                temp.add(contact);

            }

        }

        multipleAddressBook.put(input2,temp);

    }



    public boolean editContact(long phoneNumber, String addressBookName) {

        try{
            ArrayList<ContactStoring> temp = multipleAddressBook.get(addressBookName);

            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i) != null && temp.get(i).getPhoneNumber() == phoneNumber ) {

                    System.out.print("Enter First Name : ");
                    String firstName = sc.next();

                    System.out.print("Enter last Name : ");
                    String lastName = sc.next();

                    System.out.print("Enter Your City : ");
                    String city = sc.next();

                    System.out.print("Enter Your State : ");
                    String state = sc.next();

                    System.out.print("Enter Your Pin Number : ");
                    int zip = sc.nextInt();

                    System.out.print("Enter Your Email : ");
                    String email = sc.next();

                    info.get(i).setFirstName(firstName);
                    info.get(i).setLastName(lastName);
                    info.get(i).setCity(city);
                    info.get(i).setState(state);
                    info.get(i).setZip(zip);
                    info.get(i).setEmail(email);

                    return true;

                }

            }

        }
        catch (Exception e){

            System.out.println("---Address Book Not Found---");

        }

        return false;

    }

    public boolean deleteByNumber(long phoneNumber, String addressBookName) {

        try {

            ArrayList<ContactStoring> temp = multipleAddressBook.get(addressBookName);

            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i) != null && temp.get(i).getPhoneNumber() == phoneNumber ) {
                    temp.remove(i);
                    return true;
                }
            }

        }catch (Exception e){

            System.out.println("---Address Book Not Found---");
        }


        return false;
    }

    public boolean deleteAddressBook(String addressBookKey){

        ArrayList temp = multipleAddressBook.remove(addressBookKey);
        if (temp == null){
            return false;
        }
        else {
            return true;
        }

    }



    public void displayContacts() {

        System.out.println(multipleAddressBook);

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
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
