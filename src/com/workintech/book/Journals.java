package com.workintech.book;

import java.time.LocalDateTime;

public class Journals extends Book{
    public Journals(long book_ID, String author, String name, double price, boolean status, String edition, LocalDateTime date_of_purchase, String owner) {
        super(book_ID, author, name, price, status, edition, date_of_purchase, owner);
    }
}
