package com.workintech.library;

import com.workintech.book.Book;
import com.workintech.person.Author;
import com.workintech.person.Reader;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Librarian  implements Billable {
    private String name;
    private String password;

    public Librarian(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Book searchBook(Library library, String bookName) {

        for (Book book : library.getBooksInLibrary().values()) {
            if (book.getTitle().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        return null;
    }

    public boolean verifyMember(Reader reader) {
        if (reader == null) {
            System.out.println("Reader not found!");
            return false;
        }
        System.out.println("Member verified: " + reader.getName());
        return true;
    }


    public void issueBook(Library library, long bookId, Reader reader) {

        if (!verifyMember(reader)) {
            return;//üye değilse metoddan çıkack
        }
        Book book = library.getBookById(bookId);
        if (book == null) {
            System.out.println("Failed to issue the book.");
            return;
        }

        if (library.lendBooks(bookId, reader)) {
            //double amount = book.getPrice();
          //lendbookta yaptım  book.changeOwner(reader);
            //reader.borrowBooks(book);
            createBill(reader, 0);
            System.out.println("Book issued successfully to " + reader.getName());
        } else {
            System.out.println("Failed to issue the book.");
        }
    }

    public void returnBook(Library library, long bookId, Reader reader) {
        Book book = library.getBookById(bookId);
        if (book == null) {
            System.out.println("Failed to find the book.");
            return;
        }

        if (library.takeBackBook(bookId, reader)) {
            book.removeOwner();
            System.out.println("Book returned successfully by " + reader.getName());
            double refund = book.getPrice();
            System.out.println("Refund amount: " + refund + " TL");

            double fine = calculateFine(reader);
            if (fine > 0) {
                System.out.println("Late fine due: " + fine + " TL");
                createBill(reader,fine);
            }
        } else {
            System.out.println("Failed to return the book.");
        }
    }

    @Override
    public void createBill(Reader reader, double amount) {

        if (reader == null) {
            System.out.println("Invalid reader!");
            return;
        }
        System.out.println("\n========== LIBRARY BILL ==========");
        System.out.println("Librarian: " + this.name);
        System.out.println("Reader: " + reader.getName());
        System.out.println("Borrowed Books: " + reader.getBorrowedBooks().size());
        System.out.println("Fine Amount: " + amount + " TL");
        System.out.println("Date: " + LocalDateTime.now());
        System.out.println("==================================\n");

    }

    @Override
    public double calculateFine(Reader reader) {
        double totalFine = 0.0;
        int allowedDays = 14;
        double finePerDay = 8.5;

        for (Book book : reader.getBorrowedBooks()) {
            LocalDate borrowDate = reader.getBorrowDate(book);

            if (borrowDate != null) {
                long daysBorrowed = ChronoUnit.DAYS.between(borrowDate, LocalDate.now());
                long lateDays = daysBorrowed - allowedDays;

                if (lateDays > 0) {
                    totalFine += lateDays * finePerDay;
                }
            }
        }
        return totalFine;
    }

        //lambda deniyorum
    public void searchBooksByName(Library library, String name){
        if (library == null || name == null) {
            System.out.println("Invalid input for search.");
            return;
        }
        List<Book> foundBooks = library.getBooksByName(name);

        if (foundBooks.isEmpty()) {
            System.out.println(" No books found with name: " + name);
            return;
        }
       // library.getBooksByName(name).forEach(book -> book.display());    //lambda
        for (Book book : foundBooks) {
            book.display();
        }
    }

}
