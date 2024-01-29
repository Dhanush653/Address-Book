package com.bridgelabz.addressbook;
public class Main {
    public static void main(String[] args) {
        Contact contact1 = new Contact("John", "Doe", "123 Main St", "Cityville", "CA", "12345", "555-1234", "john.doe@email.com");
        Contact contact2 = new Contact("Jane", "Smith", "456 Oak St", "Townsville", "NY", "67890", "555-5678", "jane.smith@email.com");
        contact1.displayContact();
        contact2.displayContact();
    }
}