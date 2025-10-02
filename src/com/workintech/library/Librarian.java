package com.workintech.library;

import com.workintech.book.Book;

import java.util.List;

public class Librarian {
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



}
