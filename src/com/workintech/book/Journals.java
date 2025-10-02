package com.workintech.book;

import com.workintech.person.Author;

import java.time.LocalDateTime;

public class Journals extends Book{

    private String publisher;
    private int issueNumber;

    public Journals(long book_ID, Author author, String name, double price, boolean status, String edition, LocalDateTime date_of_purchase, String owner ,String publisher, int issueNumber) {
        super(book_ID, author, name, price, status, edition, date_of_purchase, owner);
        this.publisher=publisher;
        this.issueNumber=issueNumber;
    }

    public String getPublisher(){
        return publisher;
    }
    public int getIssueNumber(){
        return issueNumber;
    }
    @Override
    public void display(){
        super.display();
        System.out.println("Type : Journal ");
        System.out.println("Publisher : " + publisher);
        System.out.println("Issue Number : " + issueNumber);
    }

    @Override
    public String toString() {
        return "Journals{" +
                "Publisher='" + publisher + '\'' +
                ", Issue Number=" + issueNumber +
                '}';
    }
}
