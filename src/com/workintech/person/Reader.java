package com.workintech.person;

import com.workintech.book.Book;

import java.time.LocalDate;
import java.util.*;

public class Reader  extends Person{

    private List<Book> borrowedBooks;
    private Map<Book, LocalDate> borrowDates;

    public Reader(String name) {
        super(name);
        this.borrowedBooks=new ArrayList<>();
        this.borrowDates= new HashMap<>();
    }
    public LocalDate getBorrowDate(Book book) {
        return borrowDates.get(book);
    }

        public List<Book> getBorrowedBooks(){
        return Collections.unmodifiableList(this.borrowedBooks);
    }

    public Map<Book, LocalDate> getBorrowDates() {
        return Collections.unmodifiableMap(this.borrowDates);
    }


    public void purchaseBook(Book book){
        this.borrowedBooks.add(book);
        System.out.println(getName()+ " purchase " + book.getAuthor()+" 's best seller book : " + book.getName() + " for " + book.getPrice()+ " TL");
    }
    public void borrowBooks(Book book) {
        borrowedBooks.add(book);
        borrowDates.put(book, LocalDate.now());
        System.out.println(getName() + " borrowed the book: " + book.getName());
    }
    public void returnBooks(Book book){
        if(borrowedBooks.remove(book)){
            book.updateStatus(true);
            borrowDates.remove(book);
            System.out.println(getName() + "returned the book : " + book.getName());
        }else {
            System.out.println(getName() + "does not have this book.");
        }
    }
    public void showBooks(){
        if (borrowedBooks.isEmpty()) {
            System.out.println(getName() + " has no borrowed books.");
        } else {
            System.out.println(getName() + " has the fallowing books : ");
            for (Book book : borrowedBooks) {
                System.out.println("- " + book.getName() + " by " + book.getAuthor());
            }
        }
    }

    @Override
    public void whoyouare() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("I am " + getName() + ", a Reader with no books yet.");
        } else {
            System.out.println("I am " + getName() + ", a Reader. My favorite book is: " +
                    borrowedBooks.get(0).getName());
        }
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(getName(), reader.getName());
        //üye id si koy!!!
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + getName() + '\'' +
                "borrowedBooks=" + borrowedBooks +
                '}';
    }
}
