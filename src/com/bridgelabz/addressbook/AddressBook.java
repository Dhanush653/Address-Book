package com.bridgelabz.addressbook;
import java.util.ArrayList;
import java.util.Scanner;
public class AddressBook {
    ArrayList<Contact> contacts = new ArrayList<>();
    public Scanner scanner = new Scanner(System.in);

    public void addContactFromConsole() {
        System.out.println("Enter Additional contact details");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("State: ");
        String state = scanner.nextLine();
        System.out.print("ZIP Code: ");
        String zip = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Contact newContact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        contacts.add(newContact);
    }
    public void displayContacts(){
        for(Contact contact : contacts){
            contact.displayContact();
            System.out.println();
        }
    }

}



