package com.bookmanagement;

import java.util.ArrayList;
import java.util.List;


public class InventoryManagement {

    private static InventoryManagement instance;
    private static List<Book> booksInInventory;

    /**
     * Constructor - private
     */
    private InventoryManagement(){
        booksInInventory = new ArrayList<>();
    }

    /**
     * getter
     * @return List of books in Inventory.
     */
    public List<Book> getBooksInInventory() {
        return booksInInventory;
    }

    /**
     * Singelton class so that the whole project shares a single inventory of Books.
     * @return instance of InventoryManagement.
     */
    public static InventoryManagement getInventoryManagementInstance(){
        if (booksInInventory == null){
            instance = new InventoryManagement();
        }
        return instance;
    }

    /**
     * Adds book to Inventory.
     * @param book
     */
    public static void addBook(Book book){
        booksInInventory.add(book);
    }

    /**
     * Removes book from Inventory.
     * @param book
     */
    public static void removeBook(Book book){
        if (!booksInInventory.isEmpty() && booksInInventory.contains(book)) {
            booksInInventory.remove(book);
        }
    }

    /**
     * Print details of book for a given Title.
     * @param title
     */
    public static void searchBookByTitle(String title) {
        if (!booksInInventory.isEmpty()) {
            for (Book book : booksInInventory) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                        book.getBookDetails();
                        return;
                }
            }
        }
        System.out.println("Book with title " + title + " is not in inventory.");
    }

    /**
     * Print details of a book for an ISBN.
     * @param isbn
     */
    public static void searchBookByIsbn(String isbn){
        if (!booksInInventory.isEmpty()) {
            for (Book book : booksInInventory) {
                if (book.getIsbn().equalsIgnoreCase(isbn)) {
                    book.getBookDetails();
                    return;
                }
            }
        }
        System.out.println("Book with ISBN " + isbn + " is not in inventory.");
    }

    /**
     * Prints list of books for a given Author.
     * @param author
     */
    public static void searchBookByAuthor(String author){
        List<Book> booksByAuthor = new ArrayList<>();
        if (!booksInInventory.isEmpty()) {
            for (Book book : booksInInventory) {
                if (book.getAuthor().equalsIgnoreCase(author)) {
                        booksByAuthor.add(book);
                }
            }
        }
        if (!booksByAuthor.isEmpty()) {
            for (Book book : booksByAuthor){
                book.getBookDetails();
            }
            return;
        }
        System.out.println("Book with Author " + author + " is not in inventory.");

    }

    /**
     * Prints details of all books in Inventory.
     */
    public void printAllBookDetails(){
        for(Book book : booksInInventory){
            book.getBookDetails();
        }
    }


}
