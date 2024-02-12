package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    public static ArrayList<ContactAddress> addressbook = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) {
        System.out.println("Welcome To Address Book");
        String toAdd;

        addnewContact();
        System.out.println("Enter choice to edit(YEs):");
        String editch;
        editch = scanner.nextLine();
        if(editch.equalsIgnoreCase("yes")) {
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

        System.out.println("If you want to add new contact enter {yes} then {no}");
        toAdd = scanner.nextLine();
        if (toAdd.equalsIgnoreCase("yes")) {
            addnewContact();
            for (ContactAddress contact : addressbook) {
                System.out.println(contact);
            }
        } else {
            System.out.println("no new Contact is add");
        }

        System.out.println("Enter 1 to Delete ");
        Scanner scanner3 = new Scanner (System.in);
        int toDelete = scanner3.nextInt();
        if(toDelete == 1){
            delcontact();
            for (ContactAddress contact : addressbook) {
                System.out.println(contact);
            }
        }
        else
            System.out.println("No contacts deleted");
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
        scanner.nextLine();
        String email = scanner.nextLine();
        ContactAddress obj1 = new ContactAddress(fname, lname, address, city, zip, phnum, email);
        System.out.println(obj1);
        System.out.println("Contact added Successfully");
    }
    public static void editcontact(String firstname) {
        for (ContactAddress contact : addressbook) {
            if (contact.getFirstName().equalsIgnoreCase(firstname)) {
                System.out.println("Editing Contacts" + contact);
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Enter your details \n Firstname \n lastname \n address \n city \n zip, \n phonenum \n email \n ");
                contact.setFirstname(scanner1.nextLine());
                contact.setLastName(scanner1.nextLine());
                contact.setAddress(scanner1.nextLine());
                scanner.nextLine();
                contact.setCity(scanner1.nextLine());
                contact.setZip(scanner1.nextInt());
                contact.setPhoneNum(scanner1.nextLong());
                contact.setEmail(scanner1.nextLine());
                System.out.println("Contact edited successfully.");
            }
        }
    }
    public static void delcontact() {
        System.out.println("Enter the fname to delete:");
        Scanner scanner4 = new Scanner(System.in);
        String Conctodelete = scanner4.nextLine();

        boolean contactFound = false;
        for (ContactAddress contact : addressbook) {
            if (contact.getFirstName().equalsIgnoreCase(Conctodelete)) {
                addressbook.remove(contact);
                contactFound = true;
                System.out.println("Contact Deleted");
                System.out.println();
                break;
            }
        }
        if(!contactFound)
            System.out.println("Contact not list with given First name");
    }
}

