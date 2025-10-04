import com.workintech.book.Book;
import com.workintech.book.Journals;
import com.workintech.book.Magazines;
import com.workintech.library.Librarian;
import com.workintech.library.Library;
import com.workintech.person.Author;
import com.workintech.person.Reader;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Author author1 = new Author("Yağmur Sude Yolcu");
        Author author2 = new Author("Cahit Sıtkı Tarancı");
        Author author3 = new Author("Cemal Süreyya");
        Author author4 = new Author("Oğuz Atay");

        Book book1 = new Book(1L, author1, "Trying", 125.50, true, "Third edition", LocalDateTime.of(2025, 9, 20, 2, 20, 0), "Almina");
        Book book2 = new Book(2L, author2, "Beautiful from imaginary", 210.00, false, "Third edition", LocalDateTime.of(2025, 8, 10, 0, 5, 0), "Pınar");
        Book book3 = new Magazines(3L, author3, "Through Fashion", 180.80, true, "Fourteenth edition", LocalDateTime.of(2025, 9, 10, 0, 0), "Yağmur", "Fashion",20);
        Book book4 = new Journals(4L, author4, "The World is Chnaging", 350.75, true, "Twenty-first Edition", LocalDateTime.of(2025, 6, 6, 10, 0), "Aslı","Aden Produce",158740);


        Library library = new Library(new HashMap<>(), new HashSet<>(), new ArrayList<>());
        Librarian librarian = new Librarian("Yağmur Admin", "1846920");

        library.newBook(book1);
        author1.newBook(book1);

        library.newBook(book2);
        author2.newBook(book2);

        library.newBook(book3);
        author3.newBook(book3);

        library.newBook(book4);
        author4.newBook(book4);

        boolean running = true;

        while (running){

            System.out.println("\n=== LIBRARY SYSTEM ===");
            System.out.println("1.Show all books");
            System.out.println("2.Add new book");
            System.out.println("3.Search book by Id ");
            System.out.println("4.Search book by Name");
            System.out.println("5.Search book by Author");
            System.out.println("6.Remove book");
            System.out.println("7.List books by category");
            System.out.println("8.List books by author");
            System.out.println("9.Borrow a book");
            System.out.println("10.Return a book");
            System.out.println("11.Show all readers");
            System.out.println("12.Exit");
            System.out.print("Choose an option: ");


            int choice = scanner.nextInt();
            scanner.nextLine();

            //buradan devam et !!

        }
    }
}