package com.workintech.library;

import com.workintech.book.Book;
import com.workintech.person.Author;
import com.workintech.person.Reader;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Librarian  implements Billable {
    private String name;
    private String password;
    private static final int ALLOWED_BORROW_DAYS = 14;
    private static final double FINE_PER_DAY = 8.5;

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
            double amount = book.getPrice();
            createBill(reader, amount);
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
            //System.out.println("Book returned successfully by " + reader.getName());
            double refund = book.getPrice();
            System.out.println("Refund amount: " + refund + " TL");

            double fine = calculateFine(reader);
            if (fine > 0) {
                double netRefund = refund - fine;
                System.out.println("Late fine due: " + fine + " TL");
                System.out.println("Net refund: " + netRefund + " TL");

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
        if (reader == null) {
            return 0.0;
        }


        double totalFine = 0.0;
        int allowedDays = 14;
        double finePerDay = 8.5;

        for (Book book : reader.getBorrowedBooks()) {
            LocalDate borrowDate = reader.getBorrowDate(book);

            if (borrowDate != null) {
                long daysBorrowed = ChronoUnit.DAYS.between(borrowDate, LocalDate.now());
                long lateDays = daysBorrowed - ALLOWED_BORROW_DAYS;

                if (lateDays > 0) {
                    totalFine += lateDays * FINE_PER_DAY;
                }
            }
        }
        return totalFine;
    }

        //lambda deniyorum
    public void searchBooksByName(Library library, String name){
        if (library == null || name == null  || name.trim().isEmpty()) {
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
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Librarian librarian = (Librarian) obj;
        return Objects.equals(name, librarian.name) &&
                Objects.equals(password, librarian.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }

}
