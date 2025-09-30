import com.workintech.book.Book;
import com.workintech.person.Author;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Author author1 =new Author("Yağmur Sude Yolcu");
        Author author2 = new Author("Cahit Sıtkı Tarancı");
        Author author3 = new Author("Cemal Süreyya");
        Author author4 = new Author("Oğuz Atay");

       Book book1 = new Book(1L,author1,"Denemek",125.50,true,"Third edition",LocalDateTime.of(2025,9,20,2,20,0),"Almina");
       Book book2 =new Book(2L,author2,"Düşten Güzel",210.00,false,"Third edition",LocalDateTime.of(2025,8,10,0,5,0),"Pınar");
       Book book3 = new Book(3L,author3,"Sevda Sözleri", 180.80,true,"Fourteenth edition", LocalDateTime.of(2025, 9, 10, 0, 0),"Yağmur");
       Book book4 = new Book(4L,author4,"Korkuyu Beklerken",350.75,true,"Twenty-first Edition",LocalDateTime.of(2025,6,6,10,0),"Aslı");

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(book4);
            }
}