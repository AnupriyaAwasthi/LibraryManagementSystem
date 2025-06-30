# LibraryManagementSystem

Class Diagrams :

Book
-title : String
-author : String
-isbn : String
-publishingYear : String
-isAvailable : boolean
-issuedTo : Patron
+getters()
+setters()
+Book(String,String,String,String,boolean)
+getBookDetails()
+printBookIssuedTo()
![image](https://github.com/user-attachments/assets/9d759a08-2390-4779-ae58-917c1bd1db99)

InventoryManagement
-instance : Inventorymanagement
-booksInInventory : List<Book>
+getters()
+getInventoryManagementInstance : Inventorymanagement
-InventoryManagement()
+addBook(Book)
+removeBook(Book)
+searchBookByTitle(String)
+searchBookByIsbn(String)
+searchBookByAuthor(String)
+printAllBookDetails()
![image](https://github.com/user-attachments/assets/cafd1a06-dc7b-41b4-84e5-5cd992dfec07)

LendBookManagement
-inventory : InventoryManagement
+getters()
+setters()
+LendBookManagement(Inventorymanagement)
+checkout(Book, Patron)
+returnBook(Book)
![image](https://github.com/user-attachments/assets/4f009300-fad1-4436-86a1-0a5b0229d6fb)

Patron
-name : String
-emailId : String
-age : int
-phoneNumber : String
-location : String
+Patron(String, String, int, String, String)
+getters()
+setters()
+printPatronDetail()
![image](https://github.com/user-attachments/assets/6409b156-502a-45b1-be1c-c128d83c6563)

PatronBookHistory
-instance : PatronBookHistory
-historyOfPatron : Map<Patron, List<Book>>
+getPatronBookHistoryInstance : PatronBookHistory
-PatronBookHistory()
+getters()
+addToHistory(Patron, Book)
+printHistoryDetails()
![image](https://github.com/user-attachments/assets/8e996409-c3d7-460b-9848-3f999f7ab063)

PatronManagement
-instance : PatronManagement
-listOfPatrons : List<patron>
+getPatronManagementInstance() : PatronManagement
-PatronManagement()
+getters()
+addPatron(Patron)
+removePatron(Patron)
+updatePatron(Patron)
+getPatronDetails(Patron)
+getAllPatronDetails()
![image](https://github.com/user-attachments/assets/57f6ee0a-8497-4ea9-9d2c-f9a9c7d1f036)

RelationShips
<img width="1001" alt="Screenshot 2025-06-30 at 9 13 38 PM" src="https://github.com/user-attachments/assets/68de1d1c-b6dd-4641-9721-5f0134c4403e" />


Assumptions :

1. Only one book(single copy) for each title/isbn is present.
2. One Patron can borrow/issue n number of books.
3. No change or duration calculation considered.
4. No age check for Patron.







