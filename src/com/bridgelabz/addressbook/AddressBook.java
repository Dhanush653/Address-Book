package com.bridgelabz.addressbook;
import java.util.*;
import java.util.stream.*;


class AddressBookManager {
    static Map<String, ArrayList<ContactAddress>> addressBooks = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome To Address Book Manager");
        user();
    }
    public static void user(){
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Create new Address Book");
            System.out.println("2. Access existing Address Book");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    createNewAddressBook();
                    break;
                case 2:
                    accessExistingAddressBook();
                    break;
                default:
                    System.out.println("Invalid, Please enter a valid option.");
            }
        }

    }
    public static void createNewAddressBook() {
        System.out.println("Enter name for new Address Book:");
        String addressBookName = scanner.nextLine();
        addressBooks.put(addressBookName, new ArrayList<>());
        System.out.println("New Address Book '" + addressBookName + "' created successfully.");
    }

    public static void accessExistingAddressBook() {
        System.out.println("Enter the name of the Address Book to access:");
        String addressBookName = scanner.nextLine();

        if (addressBooks.containsKey(addressBookName)) {
            AddressBook addressBook = new AddressBook(addressBooks.get(addressBookName));
            addressBook.menu();
        } else {
            System.out.println("Address Book '" + addressBookName + "' does not exist.");
        }
    }
}

class AddressBook {

    ArrayList<ContactAddress> contacts;
    Map<String, List<ContactAddress>> cityMap = new HashMap<>();
    Map<String, List<ContactAddress>> stateMap = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public void addToCityMap(ContactAddress contact) {
        String city = contact.getCity();
        cityMap.computeIfAbsent(city, key -> new ArrayList<>()).add(contact);
    }

    public void addToStateMap(ContactAddress contact){
        String state = contact.getState();
        stateMap.computeIfAbsent(state, key -> new ArrayList<>()).add(contact);
    }
    public AddressBook(ArrayList<ContactAddress> contacts) {
        this.contacts = contacts;
        initializeMaps();
    }
    public void initializeMaps(){
        for (ContactAddress contact : contacts){
            addToCityMap(contact);
            addToStateMap(contact);
        }
    }
    public void menu() {
        while (true) {
            System.out.println("Address Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Search Person By City");
            System.out.println("5. Search Person By State");
            System.out.println("6. Go back");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    editContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    displayNamebycity();
                    break;
                case 5:
                    displayNamebystate();
                    break;
                case 6:
                    AddressBookManager.user();
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }
    public void addContact() {
        System.out.println("Enter Details: Firstname, Lastname, Address, City, State, Zip, Phnum, Email");
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String address = scanner.nextLine();
        String city = scanner.nextLine();
        String state = scanner.nextLine();
        int zip = scanner.nextInt();
        long phoneNum = scanner.nextLong();
        String email = scanner.nextLine();

        boolean isDuplicate = contacts.stream()
                .anyMatch(contact1 -> contact1.getFirstName().equalsIgnoreCase(firstName));

        if (isDuplicate) {
            System.out.println("Contact already exists with the same name. Duplicate entry not allowed.");
        } else {
            contacts.add(new ContactAddress(firstName, lastName, address, city, state, zip, phoneNum, email));
            addToCityMap(new ContactAddress(firstName, lastName, address, city, state, zip, phoneNum, email));
            addToStateMap(new ContactAddress(firstName, lastName, address, city, state, zip, phoneNum, email));
            System.out.println("Contact added successfully");
        }

    }
    public void editContact() {
        System.out.println("Enter the First name of the contact to edit:");
        String firstName = scanner.nextLine();

        for (ContactAddress contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                System.out.println("Editing Contacts" + contact);
                System.out.println("Enter your details: Firstname, Lastname, Address, City, State, Zip, Phnum, Email");
                contact.setFirstName(scanner.nextLine());
                contact.setLastName(scanner.nextLine());
                contact.setAddress(scanner.nextLine());
                contact.setCity(scanner.nextLine());
                contact.setState(scanner.nextLine());
                contact.setZip(scanner.nextInt());
                contact.setPhoneNum(scanner.nextLong());
                contact.setEmail(scanner.nextLine());
                System.out.println("Contact edited successfully.");
            }
        }
    }
    public void deleteContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the firstname to delete:");
        String contactToDelete = scanner.next();

        for (ContactAddress contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(contactToDelete)) {
                contacts.remove(contact);
                System.out.println("Contact Deleted");
                break;
            }
        }
    }
    public void displayNamebycity() {
        System.out.println("Enter The Name of The City: ");
        String city = scanner.nextLine();
        List<ContactAddress> personcity = cityMap.getOrDefault(city, new ArrayList<>()); //new ArrayList<>()- default value
        if(personcity.isEmpty()){
            System.out.println("Contact Not Found");
        }
        else{
            for(ContactAddress person : personcity){
                System.out.println(person.getFirstName() + " " + person.getLastName());
            }
        }
    }
    public void displayNamebystate(){
        System.out.println("Enter The Name Of the State: ");
        String state = scanner.next();
        List<ContactAddress> personstate = stateMap.getOrDefault(state, new ArrayList<>());
        if(personstate.isEmpty()){
            System.out.println("No Contact Found");
        }
        else{
            for(ContactAddress person : personstate){
                System.out.println(person.getFirstName() + " " + person.getLastName());
            }
        }
    }
}

