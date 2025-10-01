package com.workintech.person;

import com.workintech.book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Author extends Person{
    private List<Book> books;


    public Author(String name) {
        super(name);
        this.books=new ArrayList<>();
    }

    public void newBook (Book book){
        books.add(book);
        System.out.println(getName() + "wrote a new book : " + book.getName());
    }
    public void showBooks() {
        System.out.println(getName() + " has written the following books:");
        for (Book book : books) {
            System.out.println("- " + book.getName());
        }
    }


    @Override
    public void whoyouare() {
        if (!books.isEmpty()) {
            System.out.println("I am " + getName() + ", an Author. My favorite book is " + books.get(0).getName());
        } else {
            System.out.println("I am " + getName() + ", an Author. I haven't written any books yet.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(getName(), author.getName());     }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }

    @Override
    public String toString() {
        return "Author{" +
                "books=" + books +
                '}';
    }
}
