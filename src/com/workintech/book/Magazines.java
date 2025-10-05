package com.workintech.book;

import com.workintech.person.Author;
import com.workintech.person.Reader;

import java.time.LocalDateTime;

public class Magazines extends Book{
    private String topic;
    private int pageCount;

    public Magazines(long book_ID, Author author, String name, double price, boolean status, String edition, LocalDateTime date_of_purchase, String topic, int pageCount) {
        super(book_ID, author, name, price, status, edition, date_of_purchase);
        this.topic=topic;
        this.pageCount=pageCount;
    }

    public String getTopic(){
        return topic;
    }
    public  int getPageCount(){
        return pageCount;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public void display(){
        super.display();
        System.out.println("Topic : " + topic);
        System.out.println("Page Count : " + pageCount);
        System.out.println("-------------------------------------");

    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", Topic='" + topic + '\'' +
                ", PageCount=" + pageCount +
                '}';
    }
}
