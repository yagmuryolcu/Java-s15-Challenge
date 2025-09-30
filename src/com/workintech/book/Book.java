package com.workintech.book;
import com.workintech.person.Author;
import java.time.LocalDateTime;
import java.util.Objects;

public class Book {

    private long bookID;
    private Author author; //Composition uyguladım.
    private String name;
    private double price;
    private boolean status;
    private String edition;
    private LocalDateTime date_of_purchase;
    private String owner;

    public Book (long bookID,Author author,String name,double price,boolean status,String edition,LocalDateTime date_of_purchase,String owner){
        this.bookID=bookID;
        this.author=author;
        this.name=name;
        this.price=price;
        this.status=status;
        this.edition=edition;
        this.date_of_purchase=date_of_purchase;
        this.owner=owner;
    }

    public long getBookID(){
        return bookID;
    }
    public Author getAuthor(){
        return author;
    }
    public String getName() {
        return name;
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
        return name;
    }
    public String getOwner(){
        return owner;
    }
    public void changeOwner(String newOwner) {
        this.owner = newOwner;
        System.out.println("Book owner has been changed: : " + newOwner);
    }
    public void updateStatus(boolean newStatus) {
        this.status = newStatus;
        System.out.println("Book status has been updated: " + newStatus);
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
        System.out.println("Book ID: " + bookID);
        System.out.println("Title: " + name);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Edition: " + edition);
        System.out.println("Purchased on: " + date_of_purchase);
        System.out.println("Status: " + (status ? "Available" : "Not Available"));
        System.out.println("Owner: " + (owner != null ? owner : "No Owner"));
        System.out.println("----------------------------------------");
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
                ", Status=" + status +
                ", Edition='" + edition + '\'' +
                ", Date Of Purchase=" + date_of_purchase +
                ", Owner='" + owner + '\'' +
                '}';
    }
}
