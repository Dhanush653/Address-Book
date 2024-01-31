import com.bridgelabz.addressbook.AddressBook;
import com.bridgelabz.addressbook.Contact;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        Contact contact1 = new Contact("Dhanush", "Kumar", "466 Main Street", "Chennai", "Tamil Nadu", "12345", "12345", "xxx@email.com");
        Contact contact2 = new Contact("Ram", "Josh", "456 sub Street", "Trichy", "Tamil Nadu", "67890", "67890", "yyy@email.com");
        addressBook.addContactFromConsole();
        addressBook.displayContacts();
        contact1.displayContact();
        contact2.displayContact();
    }
}