package com.workintech.book;


import java.time.LocalDateTime;

public class Book {

    private long book_ID;
    private String author;
    private String name;
    private double price;
    private boolean status;
    private String edition;
    private LocalDateTime date_of_purchase;
    private String owner;

    public Book (long book_ID,String author,String name,double price,boolean status,String edition,LocalDateTime date_of_purchase,String owner){
        this.book_ID=book_ID;
        this.author=author;
        this.name=name;
        this.price=price;
        this.status=status;
        this.edition=edition;
        this.date_of_purchase=date_of_purchase;
        this.owner=owner;
    }

    public long getBook_ID(){
        return book_ID;
    }
    public String getAuthor(){
        return author;
    }
    public String getTitle(){
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
    public String getOwner(){
        return owner;
    }
    public void changeOwner(String newOwner) {
        this.owner = newOwner;
    }
    public void updateStatus(boolean newStatus) {
        this.status = newStatus;
    }
    public void display() {
        System.out.println("Book ID: " + book_ID);
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
    public String toString() {
        return "Book{" +
                "book_ID=" + book_ID +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition='" + edition + '\'' +
                ", date_of_purchase=" + date_of_purchase +
                ", owner='" + owner + '\'' +
                '}';
    }
}
