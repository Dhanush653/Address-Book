package com.bridgelabz.addressbook;
import java.util.*;
import java.util.stream.Collectors;


class AddressBookManager {
    static Map<String, ArrayList<ContactAddress>> addressBooks = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome To Address Book Manager");

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
    ArrayList<ContactAddress> contacts ;
    Scanner scanner = new Scanner(System.in);

    public AddressBook(ArrayList<ContactAddress> contacts) {
        this.contacts = contacts;
    }

    public void menu() {
        while (true) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Enter City To Search Names");
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
                    displayname();
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }
    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Details: Firstname, Lastname, Address, City, Zip, Phnum, Email");
        String firstName = scanner.next();
        String lastName = scanner.next();
        String address = scanner.next();
        String city = scanner.next();
        int zip = scanner.nextInt();
        long phoneNum = scanner.nextLong();
        String email = scanner.next();
        contacts.add(new ContactAddress(firstName, lastName, address, city, zip, phoneNum, email));
        System.out.println("Contact added successfully");

        boolean isDuplicate = contacts.stream()
                .anyMatch(contact -> contact.getFirstName().equalsIgnoreCase(firstName));

        if (isDuplicate) {
            System.out.println("Contact already exists with the same name. Duplicate entry not allowed.");
        } else {
            contacts.add(new ContactAddress(firstName, lastName, address, city, zip, phoneNum, email));
            System.out.println("Contact added successfully");
        }
    }

    public void editContact() {
        System.out.println("Enter the First name of the contact to edit:");
        String firstName = scanner.nextLine();

        for (ContactAddress contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                System.out.println("Editing Contacts" + contact);
                System.out.println("Enter your details: Firstname, Lastname, Address, City, Zip, Phnum, Email");
                contact.setFirstName(scanner.next());
                contact.setLastName(scanner.next());
                contact.setAddress(scanner.next());
                contact.setCity(scanner.next());
                contact.setZip(scanner.nextInt());
                contact.setPhoneNum(scanner.nextLong());
                contact.setEmail(scanner.next());
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
    public void displayname(){
        System.out.println("Enter Name Of The City: ");
        String cityname = scanner.nextLine();
        List<String> name;
        name = contacts.stream()
                .filter(person -> person.getCity().equals(cityname))
                .map(ContactAddress::getFirstName)
                .collect(Collectors.toList());
        System.out.println(name);
    }
}

