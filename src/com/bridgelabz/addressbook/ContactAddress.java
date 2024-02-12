package com.bridgelabz.addressbook;

public class ContactAddress {
    String Firstname;
    String Lastname;
    String Address;
    String City;
    int Zip;
    long Phnum;
    String Email;

    public ContactAddress(String firstname, String lastname, String address, String city, int zip, long phnum, String email) {
        Firstname = firstname;
        Lastname = lastname;
        Address = address;
        Zip = zip;
        Phnum = phnum;
        Email = email;
    } // Constructor ContactAddress
    public String getFirstName(){
        return Firstname;
    }
    public String getLastName(){
        return Lastname;
    }
    public String getAddress(){
        return Address;
    }
    public String getCity(){
        return City;
    }
    public int getZip(){
        return Zip;
    }
    public long getPhoneNum(){
        return Phnum;
    }
    public String getEmail(){
        return Email;
    }
    public void setFirstname(String firstname){
        Firstname = firstname;
    }
    public void setLastName(String lastName){
        Lastname = lastName;
    }
    public void setAddress(String address){
        Address = address;
    }
    public void setCity(String city){
        City = city;
    }
    public void setZip(int zip){
        Zip = zip;
    }
    public void setPhoneNum(long phoneNum){
        Phnum = phoneNum;
    }
    public void setEmail(String email){
        Email = email;
    }
    @Override
    public String toString() {
        return "ContactAddress{" +
                "Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", Address='" + Address + '\'' +
                ", City='" + City + '\'' +
                ", Zip=" + Zip +
                ", Phnum=" + Phnum +
                ", Email='" + Email + '\'' +
                '}';
    }
}