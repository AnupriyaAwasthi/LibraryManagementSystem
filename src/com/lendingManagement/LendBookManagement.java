package com.lendingManagement;

import com.bookmanagement.Book;
import com.bookmanagement.InventoryManagement;
import com.patronmanagement.Patron;

import static com.patronmanagement.PatronBookHistory.addToHistory;
import static com.patronmanagement.PatronManagement.getListOfPatrons;

public class LendBookManagement {
    private InventoryManagement inventory;

    public LendBookManagement(InventoryManagement intentory) {
        this.inventory = intentory;
    }

    public InventoryManagement getInventory() {
        return inventory;
    }

    public void setInventory(InventoryManagement inventory) {
        this.inventory = inventory;
    }

    /**
     * Updates Patron Details & isAvailable to false for a book for checkout.
     * Also adds the book in history of Patron's checkout.
     * @param book
     * @param patron
     */
    public void checkout(Book book, Patron patron){
        if(getListOfPatrons().isEmpty() || !getListOfPatrons().contains(patron)){
            System.out.println("Patron with name "+ patron.getName()+" is not enrolled with the library. Checkout can't be performed.");
            return;
        }
        if (!inventory.getBooksInInventory().isEmpty() && inventory.getBooksInInventory().contains(book)) {
            for (Book bookCheck : inventory.getBooksInInventory()) {
                if (bookCheck.equals(book) && bookCheck.isAvailable()) {
                    bookCheck.setAvailable(false);
                    bookCheck.setIssuedTo(patron);
                    addToHistory(patron, book);
                    System.out.println("Book with title "+ book.getTitle()+ " successfully checked out by "+ patron.getName());
                    System.out.println("--------------------------------------------");
                    return;
                }
            }
            System.out.println("The book "+book.getTitle()+" is currently out of stock.");
        } else {
            System.out.println("The book "+book.getTitle()+" is not in inventory.");
        }
    }

    /**
     * Updates Patron Details to null & isAvailable to true for a book for checkout.
     * @param book
     */
    public void returnBook(Book book) {
        if (!inventory.getBooksInInventory().isEmpty() && inventory.getBooksInInventory().contains(book)) {
            for (Book bookCheck : inventory.getBooksInInventory()) {
                if (bookCheck.equals(book)) {
                    bookCheck.setAvailable(true);
                    bookCheck.setIssuedTo(null);
                    System.out.println("Book with title "+ book.getTitle()+ " successfuuly returned. ");
                    System.out.println("--------------------------------------------");
                    return;
                }
            }
        }
    }

}
