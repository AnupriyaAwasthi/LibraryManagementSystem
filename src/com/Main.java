package com;

import com.bookmanagement.Book;
import com.bookmanagement.InventoryManagement;
import com.lendingManagement.LendBookManagement;
import com.patronmanagement.Patron;
import com.patronmanagement.PatronBookHistory;
import com.patronmanagement.PatronManagement;

import static com.bookmanagement.InventoryManagement.*;
import static com.patronmanagement.PatronBookHistory.*;
import static com.patronmanagement.PatronManagement.*;

public class Main {

    public static void main(String[] args) {

        //initialising all Singelton classes.
        InventoryManagement ims = getInventoryManagementInstance();
        PatronManagement pm = PatronManagement.getPatronManagementInstance();
        PatronBookHistory pbh = getPatronBookHistoryInstance();

        //Creating instances of Book.
        Book book1 = new Book("Love Story", "Erich Segal", "ABCD", "1999", true);
        Book book2 = new Book("Clean Code", "Robert C. Martin", "CC123", "2008", true);
        Book book3 = new Book("The Alchemist", "Paulo Coelho", "ALCH567", "1988", true);
        Book book4 = new Book("Effective Java", "Joshua Bloch", "EJ789", "2018", true);
        Book book5 = new Book("To Kill a Mockingbird", "Harper Lee", "TKM321", "1960", true);
        Book book6 = new Book("Brida", "Paulo Coelho", "BRI567", "1991", true);
        Book book7 = new Book("Let Us C", "Anupriya", "LUC567", "1989", true);


        //Adding, removing, and printing details of inventory.
        addBook(book1);
        addBook(book2);
        System.out.println("--------------------------------------------");
        System.out.println("Initial Inventory List");
        System.out.println("--------------------------------------------");
        ims.printAllBookDetails();

        addBook(book3);
        removeBook(book2);
        addBook(book4);
        addBook(book5);
        addBook(book6);

        System.out.println("--------------------------------------------");
        System.out.println("Modified Inventory List");
        System.out.println("--------------------------------------------");
        ims.printAllBookDetails();

        //Creating Patrons instances.
        Patron p1 = new Patron("Anu", "anu@gmail.com", 38, "9731511714", "Bangalore");
        Patron p2 = new Patron("Rahul", "rahul.verma@example.com", 25, "9876543210", "Delhi");
        Patron p3 = new Patron("Sneha", "sneha.kulkarni@example.com", 31, "9123456789", "Pune");
        Patron p4 = new Patron("Amit", "amit.shah@example.com", 42, "9988776655", "Mumbai");
        Patron p5 = new Patron("Neha", "neha.jain@example.com", 29, "9012345678", "Hyderabad");


        //Adding, removing, and printing Patron details.
        addPatron(p1);
        addPatron(p2);
        addPatron(p3);
        addPatron(p4);
        addPatron(p5);

        removePatron(p2);

        System.out.println("--------------------------------------------");
        System.out.println("All Patron Details :");
        System.out.println("--------------------------------------------");
        getAllPatronDetails();


        //Searching Books based on author, ISBN and title - both positive and negative cases included.
        System.out.println("--------------------------------------------");
        System.out.println("Book Search Results :");
        System.out.println("--------------------------------------------");

        searchBookByAuthor("Paulo Coelho");
        System.out.println("--------------------------------------------");
        searchBookByAuthor("Robert C. Martin");
        System.out.println("--------------------------------------------");
        searchBookByIsbn("TKM321");
        System.out.println("--------------------------------------------");
        searchBookByIsbn("HELLO");
        System.out.println("--------------------------------------------");
        searchBookByTitle("Effective Java");
        System.out.println("--------------------------------------------");
        searchBookByTitle("Effective C");
        System.out.println("--------------------------------------------");

        //Checkout and return of books.
        LendBookManagement lms = new LendBookManagement(ims);
        lms.checkout(book3,p1);
        lms.checkout(book2, p3);
        lms.checkout(book7, p5);
        lms.checkout(book1,p1);
        lms.checkout(book1, p4);
        lms.checkout(book4,p2);


        System.out.println("--------------------------------------------");
        System.out.println("Inventory List Post Checkouts");
        System.out.println("--------------------------------------------");
        ims.printAllBookDetails();

        System.out.println("--------------------------------------------");
        System.out.println("Inventory List Post Return");
        System.out.println("--------------------------------------------");
        lms.returnBook(book1);
        ims.printAllBookDetails();

        //Printing history tracking of books issued by Patrons.
        System.out.println("--------------------------------------------");
        System.out.println("History of Patrons");
        System.out.println("--------------------------------------------");
        printHistoryDetails();

        System.out.println("--------------------------------------------");
        System.out.println("Inventory List Post Checkouts");
        System.out.println("--------------------------------------------");
        lms.checkout(book1, p4);
        ims.printAllBookDetails();

        System.out.println("--------------------------------------------");
        System.out.println("History of Patrons");
        System.out.println("--------------------------------------------");
        printHistoryDetails();

        //Printing details of books issued to whom.
        System.out.println("--------------------------------------------");
        System.out.println("Book Issued to Whom Details :");
        System.out.println("--------------------------------------------");
        book3.printBookIssuedTo();
        book1.printBookIssuedTo();
        book4.printBookIssuedTo();
        book2.printBookIssuedTo();



    }
}
