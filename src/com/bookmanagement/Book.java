package com.bookmanagement;

import com.patronmanagement.Patron;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private String publishingYear;
    //Derieved Field - can be derieved from Patron.
    private boolean isAvailable;
    private Patron issuedTo;

    /**
     * Constructor.
     * @param title
     * @param author
     * @param isbn
     * @param publishingYear
     * @param isAvailable
     */
    public Book(String title, String author, String isbn, String publishingYear, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishingYear = publishingYear;
        this.isAvailable = isAvailable;
    }

    public Patron getIssuedTo() {
        return issuedTo;
    }

    public void setIssuedTo(Patron issuedTo) {
        this.issuedTo = issuedTo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(String publishingYear) {
        this.publishingYear = publishingYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /**
     * Prints details of a book.
     */
    public void getBookDetails() {
        System.out.println("Title : "+ this.title);
        System.out.println("Author : "+ this.author);
        System.out.println("ISBN : "+ this.isbn);
        System.out.println("Publishing Date : "+this.publishingYear);
        System.out.println("Available : "+ this.isAvailable);
        System.out.println("--------------------------------------------");
    }

    /**
     * Prints the details of Patron to whom a book is issued to.
     */
    public void printBookIssuedTo(){
        if(this.issuedTo != null){
            System.out.println(" The book with title "+ this.title + " is issued to following Patron : ");
            this.issuedTo.printPatronDetail();
        } else {
            System.out.println(" The book with title "+ this.title + " is not issued. ");
        }

    }

}
