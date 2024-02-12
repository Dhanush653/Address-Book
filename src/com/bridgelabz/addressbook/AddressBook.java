package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    public static ArrayList<ContactAddress> addressbook = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) {
        System.out.println("Welcome To Address Book");
        addnewContact();
        System.out.println("Enter choice to edit(1):");
        int editch;
        editch = scanner.nextInt();
        if(editch == 1) {
            System.out.println("Enter the First name to edit");
            Scanner scanner2 = new Scanner(System.in);
            String contactToEdit = scanner2.nextLine();
            editcontact(contactToEdit);
            System.out.println("All Contacts in address book");
            for (ContactAddress contact : addressbook) {
                System.out.println(contact);
            }
        }
        else
            System.out.println("No changes done in the Contact Data");

    }
    public static void addnewContact(){
        System.out.println("Enter Details \n Firstname \n lastname \n address \n city \n zip, \n phonenum \n email \n");
        String fname = scanner.nextLine();
        String lname = scanner.nextLine();
        String address = scanner.nextLine();
        String city = scanner.nextLine();
        int zip = scanner.nextInt();
        long phnum = scanner.nextLong();
        //consume the newline character left in the buffer
        String email = scanner.nextLine();
        ContactAddress obj1 = new ContactAddress(fname, lname, address, city, zip, phnum, email);
        System.out.println(obj1);
    }
    public static void editcontact(String firstname){
        for(ContactAddress contact: addressbook){
            if(contact.getFirstName().equalsIgnoreCase(firstname)){
                System.out.println("Editing Contacts"+contact);
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Enter your details \n Firstname \n lastname \n address \n city \n zip, \n phonenum \n email \n ");
                contact.setFirstname(scanner1.nextLine());
                contact.setLastName(scanner1.nextLine());
                contact.setAddress(scanner1.nextLine());
                contact.setCity(scanner1.nextLine());
                contact.setZip(scanner1.nextInt());
                contact.setPhoneNum((int) scanner1.nextLong());
                scanner1.nextLine();
                contact.setEmail(scanner1.nextLine());
                System.out.println("Contact edited successfully.");
            }
        }
    }
}

