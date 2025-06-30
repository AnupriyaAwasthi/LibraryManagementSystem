package com.patronmanagement;

public class Patron {
    private String name;
    private String emailId;
    private int age;
    private String phoneNumber;
    private String location;

    /**
     * Constructor.
     * @param name
     * @param emailId
     * @param age
     * @param phoneNumber
     * @param location
     */
    public Patron(String name, String emailId, int age, String phoneNumber, String location) {
        this.name = name;
        this.emailId = emailId;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Prints details of a Patron.
     */
    public void printPatronDetail(){
        System.out.println("Name : "+ this.name);
        System.out.println("Contact : "+ this.phoneNumber);
        System.out.println("EmailId : "+ this.emailId);
        System.out.println("Location : "+this.location);
        System.out.println("--------------------------------------------");
    }
}
