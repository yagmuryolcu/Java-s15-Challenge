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

        public void addReader(Reader reader) {
            readers.add(reader);
            //System.out.println("Reader added: " + reader.getName());
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
                if (book.getTitle().toLowerCase().contains(name.toLowerCase())) {
                    bookNames.add(book);
                }
            }

            return bookNames;
        }

        public List<Book> getBooksByAuthor( String authorName) {
            List<Book> authorNames = new ArrayList<>();

            for (Book book : booksInLibrary.values()){
                if (book.getAuthor() != null &&
                        book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                        authorNames.add(book);
                }
            }
            if (authorNames.isEmpty() ) {
                System.out.println("No books found by author: " + authorName);
            }
            return authorNames;
        }


        public void newBook(Book book) {
            if(booksInLibrary.containsKey(book.getBookID())){
                System.out.println("Book with ID " + book.getBookID() + "already exist.");
            } else {
                booksInLibrary.put(book.getBookID(), book); //kitap id si key kitabın kendisi value
                authors.add(book.getAuthor());
                //System.out.println("Book added: " + book.getTitle());
            }
        }
        public void updateBook(long bookId, Book updatedBook) {
            if (!booksInLibrary.containsKey(bookId)) {
                System.out.println("Book with ID " + bookId + " not found!");
                return;
            }
            booksInLibrary.put(bookId, updatedBook);
            authors.add(updatedBook.getAuthor());
            System.out.println("Book updated: " + updatedBook.getTitle());
        }

        public void removeBook(long bookId) {
            Book removedBook = booksInLibrary.remove(bookId);
            if (removedBook != null) {
                System.out.println("Book removed: " + removedBook.getTitle());
                showAllBooks();
            } else {
                System.out.println("Book with ID " + bookId + " not found!");
            }
        }

        public boolean lendBooks (long BookId , Reader reader){
            Book book = booksInLibrary.get(BookId);

            if ( book == null) {
                System.out.println("Book could not found.");
                return false;
            }

            if (!book.getStatus()){
                System.out.println("Book is already barrowed.");
                return false;
            }
            if (reader.getBorrowedBooks().size() >= 5) {
                System.out.println(reader.getName() + " has already borrowed 5 books. Cannot borrow more.");
                return false;
            }
            book.setStatus(false);
            book.changeOwner(reader);
            reader.borrowBooks(book);
            return true;

        }

        public boolean takeBackBook(long bookId , Reader reader) {
            Book book = booksInLibrary.get(bookId);
            if (book == null){
                System.out.println("Book could  not found.");
                return false;
            }
            if (!reader.getBorrowedBooks().contains(book)) {
                System.out.println(reader.getName() + " did not borrow this book.");
                return false;
            }
            book.updateStatus(true);
            reader.returnBooks(book);
            System.out.println(reader.getName() + " returned " + book.getTitle());
            return true;
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

        public void showAllAuthors(){
            if(authors.isEmpty()){
                System.out.println("No authors in the library.");
                return;
            }
            System.out.println("\n=== All Authors in Library ===");
            for (Author author : authors ){
                System.out.println(" - " + author.getName());
            }
        }

        public void showAllReaders() {
            if(readers.isEmpty()){
                System.out.println( "No readers in the library.");
                return;
            }
            System.out.println("\n=== All Readers in Library ===");
            for (Reader reader : readers){
                System.out.println(" - " + reader.getName() + "Borrowed books : " + reader.getBorrowedBooks());
            }
        }

        public void listBooksByCategory(Class<? extends Book> bookType) {
            System.out.println("\n=== Books in category: " + bookType.getSimpleName() + " ===");
            boolean found = false;

            for (Book book : booksInLibrary.values()) {
                if (bookType.isInstance(book)) {
                    book.display();
                    System.out.println();
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No books found in this category.");
            }
        }

        public void searchBooksByAuthor(Library library , Author author){

            if(library ==null || author == null){
                System.out.println("Invalid input for search");
                return;
            }

            List<Book> authorsAllBooks= new ArrayList<>();

            for (Book book : library.getBooksInLibrary().values()){
                if(book.getAuthor().equals(author)){
                    authorsAllBooks.add(book);
                }

            }

            if (authorsAllBooks.isEmpty()){
                System.out.println("No books found by " + author.getName() + "in the library !");
                return;
            }
            System.out.println("\n========== Books by " + author.getName() + " ==========");
            System.out.println("Total books found : " + authorsAllBooks.size());
            System.out.println("===================================================/n");

            authorsAllBooks.forEach(Book::display);//lambda
        }



        }


