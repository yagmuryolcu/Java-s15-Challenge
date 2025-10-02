package com.workintech.book;

import com.workintech.person.Author;

import java.time.LocalDateTime;

public class Magazines extends Book{
    private String topic;
    private int pageCount;

    public Magazines(long book_ID, Author author, String name, double price, boolean status, String edition, LocalDateTime date_of_purchase, String owner,String topic, int pageCount) {
        super(book_ID, author, name, price, status, edition, date_of_purchase, owner);
        this.topic=topic;
        this.pageCount=pageCount;
    }

    public String getTopic(){
        return topic;
    }
    public  int getPageCount(){
        return pageCount;
    }

    @Override
    public void display(){
        System.out.println("Type : Magazines ");
        System.out.println("Topic : " + topic);
        System.out.println("Page Count : " + pageCount);
    }

    @Override
    public String toString() {
        return "Magazines{" +
                "Topic='" + topic + '\'' +
                ", Page Count=" + pageCount +
                '}';
    }
}
