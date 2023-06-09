
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBooking_Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("---Welcome To The Address Book Storing System---");
        AddressBookFeatures contact = new AddressBookFeatures();


        int in;
        do {

            System.out.println("---------------------------------------------------------");

            System.out.println("-->>Press 0 to Add AddressBooks<<--" +
                    "\n-->>Press 1 To Edit Contacts<<--" +
                    "\n-->>Press 2 To Delete Contacts<<--" +
                    "\n-->>Press 3 To Delete Address Book<<--" +
                    "\n-->>Press 4 To Display The Address Books<<--" +
                    "\n-->>Press 5 To Search Contacts By City<<--" +
                    "\n-->>Press 6 To See The Person Count According To City<<--" +
                    "\n-->>Press 7 To Sort AddressBook Using Name<<--" +
                    "\n-->>Press 8 To Sort By Choice<<--" +
                    "\n-->>Press 9 To Write To File<<--" +
                    "\n-->>Press 10 To Read From File<<--" +
                    "\n-->>Press 11 To Close The Program<<--");
            System.out.println("----------------------------------------------------------");
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
                    boolean updated = contact.editContact(phoneNumber, userInput);

                    if (updated) {
                        System.out.println("---Contact Updated---");
                    } else {
                        System.out.println("---Contact not found---");
                    }
                    break;
                }

                case 2: {

                    System.out.print("Enter The Address Book Name: ");
                    String userInput = sc.next();

                    System.out.print("Enter Your PhoneNumber For Confirmation : ");
                    long phoneNumber = sc.nextLong();
                    boolean updated = contact.deleteByNumber(phoneNumber, userInput);
                    if (updated) {
                        System.out.println("---Contact Deleted---");
                    } else {
                        System.out.println("---Contact not found---");
                    }
                    break;
                }

                case 4: {

                    contact.displayContacts();
                    break;

                }

                case 11: {

                    System.out.println("--->Application Closing || Thank You For Using Address Book Service<---");
                    break;
                }

                case 3: {

                    System.out.print("Enter The Address Book Name: ");
                    String userInput = sc.next();
                    boolean updated = contact.deleteAddressBook(userInput);
                    if (updated) {
                        System.out.println("---Address Book Deleted---");
                    } else {
                        System.out.println("---Address Book Not Found---");
                    }
                    break;


                }

                case 5: {

                    System.out.print("Enter AddressBook Name : ");
                    String userInput = sc.next();
                    System.out.print("Enter The City : ");
                    String user = sc.next();
                    boolean update = contact.searchByCity(userInput, user);
                    if (!update) {
                        System.out.println("---City Not Found---");
                    }
                    break;

                }

                case 6: {

                    System.out.print("Enter The AddressBook Name : ");
                    String input = sc.next();
                    System.out.print("Enter The City : ");
                    String cityInput = sc.next();

                    boolean update = contact.getCountOfContact(input, cityInput);
                    if (!update) {
                        System.out.println("---City Not Found---");
                    }
                    break;

                }

                case 7: {
                    System.out.print("Enter AddressBook Name : ");
                    String userInput = sc.next();
                    contact.sortByName(userInput);
                    break;
                }
                case 8:{
                    System.out.print("Enter The AddressBook Name : ");
                    String userInput = sc.next();
                    contact.sortByChoice(userInput);
                    break;
                }

                case 9:{

                    contact.writeDataToFile();
                    break;

                }

                case 10:{

                    contact.readFromFile();
                    break;

                }

                default:
                    System.out.println("Please Enter The Correct Choice");
                    break;
            }

        } while (in != 11);

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

        if (multipleAddressBook.containsKey(input2)) {
            System.out.println("-----Address Book Already Exists-----");
        } else {

            System.out.print("How Many Contacts You Want To Store? -->> ");
            int userInput = sc.nextInt();
            for (int i = 0; i < userInput; i++) {

                System.out.print("Enter First Name : ");
                String firstName = sc.next();

                boolean update = temp.stream().anyMatch(x -> x.getFirstName().equalsIgnoreCase(firstName));
                if (update) {
                    System.out.println("---Contact Already Exists---");
                } else {

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

        }

        multipleAddressBook.put(input2, temp);

    }


    public boolean editContact(long phoneNumber, String addressBookName) {

        try {
            ArrayList<ContactStoring> temp = multipleAddressBook.get(addressBookName);

            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i) != null && temp.get(i).getPhoneNumber() == phoneNumber) {

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

        } catch (Exception e) {

            System.out.println("---Address Book Not Found---");

        }

        return false;

    }

    public boolean deleteByNumber(long phoneNumber, String addressBookName) {

        try {

            ArrayList<ContactStoring> temp = multipleAddressBook.get(addressBookName);

            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i) != null && temp.get(i).getPhoneNumber() == phoneNumber) {
                    temp.remove(i);
                    return true;
                }
            }

        } catch (Exception e) {

            System.out.println("---Address Book Not Found---");
        }


        return false;
    }

    public boolean deleteAddressBook(String addressBookKey) {

        ArrayList temp = multipleAddressBook.remove(addressBookKey);
        if (temp == null) {
            return false;
        } else {
            return true;
        }

    }

    public boolean searchByCity(String addressBookName, String city) {

        try {
            ArrayList<ContactStoring> temp = multipleAddressBook.get(addressBookName);
            temp.stream().filter(a -> a.getCity().equalsIgnoreCase(city)).forEach(x -> System.out.println(x.getFirstName() + "\n"));
            return true;
        } catch (Exception e) {
            System.out.println("---Address Book Not Found---");
        }
        return false;

    }

    public boolean getCountOfContact(String addressBookName, String city) {

        try {
            ArrayList<ContactStoring> temp = multipleAddressBook.get(addressBookName);
            long count = temp.stream().filter(x -> x.getCity().equalsIgnoreCase(city)).collect(Collectors.counting());
            System.out.println("Persons Available in The City is : " + count);
            return true;
        } catch (Exception e) {
            System.out.println("---AddressBook Not Found---");
        }
        return false;
    }

    public void sortByName(String addressBookName){

        ArrayList<ContactStoring> temp = multipleAddressBook.get(addressBookName);
        List list = temp.stream().sorted((f,s)-> f.getFirstName().compareTo(s.getFirstName())).collect(Collectors.toList());
        System.out.println(list);

    }

    public void sortByChoice(String addressBookName){

        ArrayList<ContactStoring> temp = multipleAddressBook.get(addressBookName);
        System.out.println("Press 1 to Sort By City\nPress 2 to Sort By State\nPress 3 to Sort By ZIP");
        System.out.print("Your Choice : ");
        int input = sc.nextInt();

        switch (input){
            case 1:{
                List cityList = temp.stream().sorted((f,s)-> f.getCity().compareTo(s.getCity())).collect(Collectors.toList());
                System.out.println(cityList);
                break;
            }
            case 2:{
                List cityList = temp.stream().sorted((f,s)-> f.getState().compareTo(s.getState())).collect(Collectors.toList());
                System.out.println(cityList);
                break;
            }
            case 3:{
                List cityList = temp.stream().sorted((f,s)-> Long.valueOf(f.getZip()).compareTo(Long.valueOf(s.getZip()))).collect(Collectors.toList());
                System.out.println(cityList);
                break;
            }

        }

    }

    public void writeDataToFile(){

        BufferedWriter bufferedWriter= null;
        try{
            bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\asaha\\Desktop\\Java_Fellowship_242\\AddressBookSystem_ALL\\src\\OutputAddresses.txt"));
            for (Map.Entry<String,ArrayList> entry : multipleAddressBook.entrySet()){
                bufferedWriter.write(entry.getKey()+ " : " + entry.getValue());
                bufferedWriter.newLine();
            }
            System.out.println("---File Added Successfully---");
            bufferedWriter.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                bufferedWriter.close();
            }
            catch (Exception e){

            }
        }
    }

    public void readFromFile(){

        BufferedReader bufferedReader = null;

        try{
            bufferedReader = new BufferedReader(new FileReader("C:\\Users\\asaha\\Desktop\\Java_Fellowship_242\\AddressBookSystem_ALL\\src\\OutputAddresses.txt"));
            String line;
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {

                }
            }
        }

    }



    public void displayContacts() {

        for (String key : multipleAddressBook.keySet()) {
            System.out.println(key + " : " + multipleAddressBook.get(key));
        }

    }

}


class ContactStoring {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private long phoneNumber;
    private String email;


    public ContactStoring(String firstName, String lastName, String city, String state, int zip, long phoneNumber, String email) {
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