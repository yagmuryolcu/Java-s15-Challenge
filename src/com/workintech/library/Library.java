package com.workintech.library;

import com.workintech.book.Book;
import com.workintech.person.Author;
import com.workintech.person.Reader;

import java.util.*;

public class Library {
    private Map< Long , Book> booksInLibrary; //id ye göre kitabı bulacak, benzersiz data tutacak,hızlı
    private Set<Author> authors; //tekrar eden veri yok
    private List<Reader> readers; // index var, tekrar edebilir.


    public Library(Map<Long, Book> booksInLibrary, Set<Author> authors, List<Reader> readers) {
        this.booksInLibrary = Objects.requireNonNull(booksInLibrary);
        this.authors = Objects.requireNonNull(authors);
        this.readers = Objects.requireNonNull(readers);
    }
    public Map<Long,Book> getBooksInLibrary(){
        return Collections.unmodifiableMap(this.booksInLibrary);
    }
    public Set<Author> getAuthors(){
        return Collections.unmodifiableSet(this.authors);
    }
    public List<Reader> getReaders(){
        return Collections.unmodifiableList(this.readers);
    }

    public void newBook(Book book) {
        if(booksInLibrary.containsKey(book.getBookID())){
            System.out.println("Book with ID " + book.getBookID() + "already exist.");
        } else {
            booksInLibrary.put(book.getBookID(), book); //kitap id si key kitabın kendisi value
            authors.add(book.getAuthor());
            System.out.println("Book added: " + book.getName());
        }
    }

    public void addReader(Reader reader) {
        readers.add(reader);
        System.out.println("Reader added: " + reader.getName());
    }

    public Book getBookById(long bookID){
        Book book = booksInLibrary.get(bookID);
        if ( book == null){
            System.out.println("Book with ID : " + bookID + " not found. ");
        }
        return book;
    }

    public List<Book> getBooksByName(String name) {
        List<Book> bookNames = new ArrayList<>();

        for (Book book : booksInLibrary.values()) {
            if (book.getName().toLowerCase().contains(name.toLowerCase())) {
                bookNames.add(book);
            }
        }

        if (bookNames.isEmpty()) {
            System.out.println("No books found with name: " + name);
        }

        return bookNames;
    }

    public List<Book> getBooksByReader( String authorName) {
        List<Book> readerNames = new ArrayList<>();

        for (Book book : booksInLibrary.values()){
            if(book.getAuthor().getName().equalsIgnoreCase(authorName)){
                readerNames.add(book);
            }
        }
        if (readerNames.isEmpty()) {
            System.out.println("No books found by author: " + authorName);
        }
        return readerNames;
    }

    public void updateBook(long bookId, Book updatedBook) {
        if (!booksInLibrary.containsKey(bookId)) {
            System.out.println("Book with ID " + bookId + " not found!");
            return;
        }
        booksInLibrary.put(bookId, updatedBook);
        authors.add(updatedBook.getAuthor());
        System.out.println("Book updated: " + updatedBook.getName());
    }

    public void removeBook(long bookId) {
        Book removedBook = booksInLibrary.remove(bookId);
        if (removedBook != null) {
            System.out.println("Book removed: " + removedBook.getName());
        } else {
            System.out.println("Book with ID " + bookId + " not found!");
        }
    }
    public void showAllBooks() {
        if (booksInLibrary.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("\n=== All Books in Library ===");
        for (Book book : booksInLibrary.values()) {
            book.display();
        }
    }

    //kategoriye göre kitap listeleme , ödünç alma kısmını ekle!!
    }


