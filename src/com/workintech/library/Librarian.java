package com.workintech.library;

import com.workintech.book.Book;
import com.workintech.person.Reader;

import java.time.LocalDate;
import java.util.List;

public class Librarian  implements Billable{
    private String name;
    private String password;

    public Librarian (String name, String password){
        this.name=name;
        this.password=password;
    }

    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }

    public Book searchBook(String bookName, List<Book> books){
    for (Book book : books) {
        if(book.getName().equalsIgnoreCase(bookName)){
            return book;
        }
    }
    return  null;
    }


    public boolean verifyMember(Reader reader) {
        if (reader == null) {
            System.out.println("Reader not found!");
            return false;
        }
        System.out.println("Member verified: " + reader.getName());
        return true;
    }


    public void issueBook (Library library , long bookId , Reader reader){

        if (!verifyMember(reader)) {
            return;//üye değilse metoddan çıkack
        }

        if (library.lendBooks(bookId,reader)){
            System.out.println("Book issued successfully to " + reader.getName());
        }else{
            System.out.println("Failed to issue the book.");
        }
    }

    public void returnBook ( Library library, long bookId, Reader reader){
        if ( library.takeBackBook(bookId,reader)){
            System.out.println("Book returned successfully by " + reader.getName());
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
        System.out.println("Late Days : " + calculateFine(reader));
        System.out.println("Fine Amount: " + amount + " TL");
        System.out.println("Date: " + LocalDate.now());
        System.out.println("==================================\n");

    }

    @Override
    public double calculateFine(Reader reader) {
        int lateDays = reader.getBorrowedBooks().size() * 3;

        if ( lateDays <=0){
            return 0.0;
        }

        double finePerDay = 8.5;
        double totalFine = lateDays * finePerDay;

        System.out.println("Fine calculated for " + reader.getName() + ": " + totalFine + " TL");
        return totalFine;
    }

        //lambda deniyorum
    public void searchBooksByName(Library library, String name){
       // library.getBooksByName(name).forEach(book -> book.display());    //lambda
        for (Book book : library.getBooksByName(name)) {
            book.display();
        }
    }


}
