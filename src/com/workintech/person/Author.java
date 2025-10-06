package com.workintech.person;

import com.workintech.book.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Author extends Person{
    private List<Book> books;


    public Author(String name) {
        super(name);
        this.books=new ArrayList<>();
    }
    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }
    public void newBook (Book book){
        if (book != null && !books.contains(book)) {
            books.add(book);
           // System.out.println(getName() + " added new book: " + book.getTitle());
        }
    }
    public void showBooks() {

        if (books.isEmpty()) {
            System.out.println(getName() + " has not written any books yet.");
            return;
        }
        System.out.println("\n========== Books by " + getName() + " ==========");
        System.out.println("Total books: " + books.size());
        System.out.println(getName() + " has written the following books:");
        for (Book book : books) {
            System.out.println("- " + book.getTitle() + " (" + book.getEdition() + ") - " + book.getPrice() + " TL");
        }
        System.out.println();
    }


    @Override
    public void whoyouare() {
        if (!books.isEmpty()) {
            System.out.println("I am " + getName() + ", an Author. My favorite book is " + books.get(0).getTitle());
        } else {
            System.out.println("I am " + getName() + ", an Author. I haven't written any books yet.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
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
                "Name='" + getName() + '\'' +
                ", Books Count=" + books.size() +
                '}';
    }
}
