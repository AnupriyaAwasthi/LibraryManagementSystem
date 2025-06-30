package com.patronmanagement;


import com.bookmanagement.Book;
import com.bookmanagement.InventoryManagement;

import java.util.ArrayList;
import java.util.List;

public class PatronManagement {

    private static PatronManagement instance;
    private static List<Patron> listOfPatrons;


    private PatronManagement(){
        listOfPatrons = new ArrayList<>();
    }

    /**
     * Singelton class so that the whole project shares a single list of Patron.
     * @return
     */
    public static PatronManagement getPatronManagementInstance(){
        if (listOfPatrons == null){
            instance = new PatronManagement();
        }
        return instance;
    }

    public static List<Patron> getListOfPatrons() {
        return listOfPatrons;
    }

    /**
     * Adds Patron to list.
     * @param patron
     */
    public static void addPatron(Patron patron) {
        listOfPatrons.add(patron);
    }

    /**
     * removes Patron to list.
     * @param patron
     */
    public static void removePatron(Patron patron){
        if (!listOfPatrons.isEmpty() && listOfPatrons.contains(patron)) {
            listOfPatrons.remove(patron);
        }
    }

    /**
     * Update details of a Patron.
     * @param patron
     */
    public static void updatePatron(Patron patron) {
        if (!listOfPatrons.isEmpty() && listOfPatrons.contains(patron)) {
            for (Patron patronCheck : listOfPatrons) {
                if(patronCheck.equals(patron)){
                    patronCheck.setName(patron.getName());
                    patronCheck.setAge(patron.getAge());
                    patronCheck.setEmailId(patron.getEmailId());
                    patronCheck.setPhoneNumber(patron.getPhoneNumber());
                    patronCheck.setLocation(patron.getLocation());
                    System.out.println("Patron detail successfully updated.");
                    System.out.println("----------------------------------------");
                    return;
                }
            }
        }
        System.out.println("Patron "+ patron.getName()+ " not found.");
    }

    /**
     * Prints details of a Patron - to check if a patron is present or not.
     * @param patron
     */
    public static void getPatronDetails(Patron patron){
        if (!listOfPatrons.isEmpty() && listOfPatrons.contains(patron)) {
            for (Patron patronCheck : listOfPatrons) {
                if (patronCheck.equals(patron)){
                patronCheck.printPatronDetail();
                    return;
                }
            }
        }
        System.out.println("Patron "+ patron.getName()+ " not found.");
    }

    /**
     * Print details of all the Patrons.
     */
    public static void getAllPatronDetails(){
        if (!listOfPatrons.isEmpty()) {
            for (Patron patronCheck : listOfPatrons) {
                    patronCheck.printPatronDetail();
            }
        }
    }
}
