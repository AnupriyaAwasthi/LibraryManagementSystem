package com.patronmanagement;

import com.bookmanagement.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatronBookHistory {

    private static PatronBookHistory instance;
     private static Map<Patron, List<Book>> historyOfPatron ;//= new HashMap<>();

    /**
     *Singelton class so that the whole project shares a single mapping for all Patrons.
     * @return PatronBookHistory.
     */
    public static PatronBookHistory getPatronBookHistoryInstance(){
        if (historyOfPatron == null){
            instance = new PatronBookHistory();
        }
        return instance;
    }

    private PatronBookHistory(){
        historyOfPatron = new HashMap<>();
    }

    public Map<Patron, List<Book>> getHistoryOfPatron() {
        return historyOfPatron;
    }

    /**
     * Add book to list of Books issued by a Patron to keep a history of all books issued.
     * @param patron
     * @param book
     */
    public static void addToHistory(Patron patron, Book book) {
        if(historyOfPatron.containsKey(patron)){
            List<Book> bookList = historyOfPatron.get(patron);
            if(!bookList.contains(book)) {
                bookList.add(book);
            }
        } else {
            List<Book> booklist = new ArrayList();
            booklist.add(book);
            historyOfPatron.put(patron,booklist);
        }

    }

    /**
     * Prints all the books issued to each Patron.
     */
    public static void printHistoryDetails(){
        if ( historyOfPatron.isEmpty()) {
            System.out.println("No Historical Data present.");
            return;
        }
        for (Map.Entry<Patron, List<Book>> entry : historyOfPatron.entrySet()) {
            Patron patron = entry.getKey();
            List<Book> books = entry.getValue();

            System.out.println(patron.getName() + ": "); // Or override toString() in Patron
            for (Book book : books) {
                book.getBookDetails();
            }
            System.out.println();
        }

    }
}
