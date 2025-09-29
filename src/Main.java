import com.workintech.book.Book;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book(1L,"Cemal Süreyya","Sevda Sözleri", 180.80,true,"Fourteenth edition", LocalDateTime.of(2025, 9, 10, 0, 0),"Yağmur");
        System.out.println(book1);
            }
}