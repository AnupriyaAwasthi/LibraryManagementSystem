# LibraryManagementSystem

Class Diagrams :


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
![image](https://github.com/user-attachments/assets/77c74958-1279-415d-8d5a-016af8a4a7cb)

LendBookManagement
-inventory : InventoryManagement
+getters()
+setters()
+LendBookManagement(Inventorymanagement)
+checkout(Book, Patron)
+returnBook(Book)
![image](https://github.com/user-attachments/assets/dce9c090-5d3e-4ae5-86db-ce7811aeb87a)

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
![image](https://github.com/user-attachments/assets/bf581ded-beb9-440d-b5e2-e20f24e423f0)

PatronBookHistory
-instance : PatronBookHistory
-historyOfPatron : Map<Patron, List<Book>>
+getPatronBookHistoryInstance : PatronBookHistory
-PatronBookHistory()
+getters()
+addToHistory(Patron, Book)
+printHistoryDetails()
![image](https://github.com/user-attachments/assets/e5ddf855-6817-4242-851e-5fc98597ed1e)

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
![image](https://github.com/user-attachments/assets/531bf34a-cf8d-4ddc-818e-c2ee798f5c5d)



RelationShips
<img width="1001" alt="Screenshot 2025-06-30 at 9 13 38 PM" src="https://github.com/user-attachments/assets/68de1d1c-b6dd-4641-9721-5f0134c4403e" />


Assumptions :

1. Only one book(single copy) for each title/isbn is present.
2. One Patron can borrow/issue n number of books.
3. No change or duration calculation considered.
4. No age check for Patron.







