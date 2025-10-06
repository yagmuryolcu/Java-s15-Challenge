package com.workintech.book;
import com.workintech.person.Author;
import com.workintech.person.Reader;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Objects;

public class Book {

    private long bookID;
    private Author author; //Composition uyguladım.
    private String name;
    private double price;
    private boolean status;
    private String edition;
    private LocalDateTime date_of_purchase;
    private Reader owner;

    public Book (long bookID,Author author,String name,double price,boolean status,String edition,LocalDateTime date_of_purchase){
        this.bookID=bookID;
        this.author= Objects.requireNonNull(author);
        this.name=Objects.requireNonNull(name);
        this.price=price;
        this.status=status;
        this.edition=Objects.requireNonNull(edition);
        this.date_of_purchase = Objects.requireNonNull(date_of_purchase);
        this.owner=null;
    }

    public long getBookID(){
        return bookID;
    }
    public Author getAuthor(){
        return author;
    }
    public double getPrice(){
        return price;
    }
    public boolean getStatus(){
        return status;
    }
    public String getEdition(){
        return edition;
    }
    public LocalDateTime getDate_of_purchase(){
        return  date_of_purchase;
    }
    public String getTitle(){
        return name ;
    }
    public Reader getOwner(){
        return owner;
    }


    public void changeOwner(Reader newOwner) {
        if (this.owner == null) {
            this.owner = newOwner;
            this.status = false;
            System.out.println("Book owner has been changed: : " + newOwner.getName());

        }else if (this.owner.equals(newOwner)) {
            System.out.println("Book is already borrowed by : " + newOwner.getName());

        }else {
            System.out.println("The Book /'" + name + "'/ is currently borrowed by " + owner.getName()+ "."+ newOwner.getName()+ "cannot borrow !");
        }
    }
    public void removeOwner() {
        if (this.owner != null) {
            System.out.println(owner.getName() + " has returned the book \"" + name + "\".");
            this.owner = null;
            this.status = true;
        } else {
            System.out.println(" The book \"" + name + "\" is already in the library.");
        }
    }

    public void updateStatus(boolean newStatus) {
        this.status = newStatus;
       // System.out.println("Book status has been updated: " + newStatus);
    }
    public void setBookID(long bookID){
        this.bookID=bookID;
    }
    public void setAuthor( Author author){
        this.author=author;
    }
    public void setName( String name){
        this.name=name;
    }
    public void setPrice (double price){
        this.price=price;
    }
    public void setStatus(boolean status){
        this.status=status;
    }
    public void setEdition (String edition){
        this.edition=edition;
    }
    public void setDate_of_purchase( LocalDateTime date_of_purchase){
        this.date_of_purchase=date_of_purchase;
    }


    public void display() {
        System.out.println("----------------------------------------");
        System.out.println("Book ID: " + bookID);
        System.out.println("Title: " + name);
        System.out.println("Author: " + author.getName());
        System.out.println("Price: " + price + "TL");
        System.out.println("Edition: " + edition);
        System.out.println("Purchased on: " + date_of_purchase);
        System.out.println("Status: " + (status ? "Available" : "Not Available"));
        System.out.println("Owner: " + (owner != null ? owner.getName() : "No Owner"));
        System.out.println("Type: " + this.getClass().getSimpleName());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookID, book.bookID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookID);
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID=" + bookID +
                ", Author='" + author.getName() + '\'' +
                ", Name='" + name + '\'' +
                ", Price=" + price +
                ", Status=" + (status ? "Available" : "Not Available") +
                ", Edition='" + edition + '\'' +
                ", DateOfPurchase=" + date_of_purchase +
                ", Owner='" + (owner != null ? owner.getName() : "No Owner") + '\'' +
                ", Type='" + this.getClass().getSimpleName() + '\'' +
                '}';
    }
}
