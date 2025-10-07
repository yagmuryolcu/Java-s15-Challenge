    import com.workintech.book.Book;
    import com.workintech.book.Journals;
    import com.workintech.book.Magazines;
    import com.workintech.book.StudyBooks;
    import com.workintech.library.Librarian;
    import com.workintech.library.Library;
    import com.workintech.person.*;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.util.*;

    public class Main {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            Author author1 = new Author("Yağmur Sude Yolcu");
            Author author2 = new Author("Cahit Sıtkı Tarancı");
            Author author3 = new Author("Cemal Süreyya");
            Author author4 = new Author("Oğuz Atay");
            Author author5 = new Author("Esin Kaçar");
            Author author6 = new Author("Can Yıldız");

            MemberRecord record1 = new MemberRecord(10, "Reader", LocalDateTime.now(), 0, 5, "Ayşe Yanar", "Istanbul", "0555 000 0001");
            MemberRecord record2 = new MemberRecord(20, "Reader", LocalDateTime.now(), 0,5, "Esin Çift", "Ankara", "0555 000 0002");
            MemberRecord record3 = new MemberRecord(30, "Reader", LocalDateTime.now(), 0,5, "Ayberk Torun", "Ankara", "0555 100 8802");
            MemberRecord record4 = new MemberRecord(40, "Reader", LocalDateTime.now(), 0,5, "Beyza Kayır", "Ankara", "0525 180 8872");
            Student record5 =new Student(50,"Student",LocalDateTime.now(),0,5,"Derin Akbulut","Eskişehir","5841236654","847152","MIS",4);
            Faculty record6 = new Faculty(60, LocalDateTime.now(), 0, "Ali Kılınç", "Maslak", "215423665", "Computer Engineering", "Dr.", "748568");

            Reader reader1=new Reader("Ayşe Yanar",record1);
            Reader reader2=new Reader("Esin Çift",record2);
            Reader reader3= new Reader("Ayberk Torun",record3);
            Reader reader4=new Reader("Beyza Kayır",record4);
            Reader reader5=new Reader("Derin Akbulut",record5);
            Reader reader6=new Reader("Ali Kılınç",record6);


            Book book1 = new Book(1L, author1, "Trying", 125.50, true, "Third edition", LocalDateTime.of(2025, 9, 20, 2, 20, 0));
            Book book2 = new Book(2L, author2, "Beautiful from imaginary", 210.00, true, "Third edition", LocalDateTime.of(2025, 8, 10, 0, 5, 0));
            Book book3 = new Magazines(3L, author3, "Through Fashion", 180.80, true, "Fourteenth edition", LocalDateTime.of(2025, 9, 10, 0, 0), "Fashion",20);
            Book book4 = new Journals(4L, author4, "The World is Chnaging", 350.75, true, "Twenty-first Edition", LocalDateTime.of(2025, 6, 6, 10, 0),"Aden Produce",158740);
            Book book5 =new Book(5L,author5,"Love",350.00,true,"First Edition",LocalDateTime.now());
            Book book6 = new StudyBooks(6L,author2,"History",180.00,true,"Second Edition",LocalDateTime.now(),"History","High School");
            Book book7=new Magazines(7L,author6,"Night Birds",100.00,true,"Second edition",LocalDateTime.now(),"Aegument in celebrities",10);

            Library library = Library.getInstance(1L, new TreeMap<>(), new HashSet<>(), new ArrayList<>());
            Librarian librarian = new Librarian("Yağmur Admin", "1846920");

            library.newBook(book1);
            author1.newBook(book1);

            library.newBook(book2);
            author2.newBook(book2);

            library.newBook(book3);
            author3.newBook(book3);

            library.newBook(book4);
            author4.newBook(book4);

            library.newBook(book5);
            author5.newBook(book5);

            library.newBook(book6);
            author2.newBook(book6);

            library.newBook(book7);
            author6.newBook(book7);

            library.addReader(reader1);
            library.addReader(reader2);
            library.addReader(reader3);
            library.addReader(reader4);
            library.addReader(reader5);
            library.addReader(reader6);

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
                System.out.println("12.Show all authors");
                System.out.println("13.Update book information");
                System.out.println("14.Show reader details");
                System.out.println("15.Exit");
                System.out.print("Choose an option: ");


                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice){
                    case 1 :
                        library.showAllBooks();
                        break;
                    case 2:
                        System.out.println("Enter Book ID : ");
                        long id = scanner.nextLong();
                        scanner.nextLine();

                        System.out.println("Enter Book Name : ");
                        String name=scanner.nextLine();

                        System.out.print("Enter Author Name: ");
                        String authorName = scanner.nextLine();
                        Author author = new Author(authorName);

                        System.out.print("Enter Price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Enter Edition: ");
                        String edition = scanner.nextLine();

                        System.out.print("Select Book Type: (1-StudyBook, 2-Journal, 3-Magazine): ");
                        int type = scanner.nextInt();
                        scanner.nextLine();


                        Book newBook;
                switch (type) {
                    case 1 -> {
                                System.out.print("Subject: ");
                                String subject = scanner.nextLine();
                                System.out.print("Grade Level: ");
                                String gradeLevel = scanner.nextLine();
                                newBook = new StudyBooks(id, author, name, price, true, edition, LocalDateTime.now(), subject, gradeLevel);
                            }
                    case 2 -> {
                                System.out.print("Publisher: ");
                                String publisher = scanner.nextLine();
                                System.out.print("Issue Number: ");
                                int issueNumber = scanner.nextInt();
                                scanner.nextLine();
                                newBook = new Journals(id, author, name, price, true, edition, LocalDateTime.now(), publisher, issueNumber);
                            }
                    case 3 -> {
                                System.out.print("Topic: ");
                                String topic = scanner.nextLine();
                                System.out.print("Page Count: ");
                                int pageCount = scanner.nextInt();
                                scanner.nextLine();
                                newBook = new Magazines(id, author, name, price, true, edition, LocalDateTime.now(), topic, pageCount);
                            }
                    default -> {
                                System.out.println("Invalid type, defaulting to StudyBook.");
                                newBook = new StudyBooks(id, author, name, price, true, edition, LocalDateTime.now(), "Unknown", "Unknown");
                            }
                        }

                        library.newBook(newBook);
                        author.newBook(newBook);
                        break;

                    case 3:
                        System.out.println("Search Book By Id : ");
                        long searchId= scanner.nextLong();
                        scanner.nextLine();
                        Book findBookById = library.getBookById(searchId);
                        if(findBookById != null){
                            findBookById.display();
                        }
                        break;
                    case 4:
                        System.out.println("Search book By Name : ");
                        String searchName = scanner.nextLine();
                        librarian.searchBooksByName(library,searchName);
                        break;
                    case 5:
                        System.out.println("Search Book By Author : ");
                        String searchAuthor = scanner.nextLine();
                        List<Book> booksByAuthor = library.getBooksByAuthor(searchAuthor);
                        for (Book book : booksByAuthor) {
                            book.display();
                        }
                        break;
                    case 6 :
                        System.out.println("Enter Book ID to remove : ");
                        long removeId = scanner.nextLong();
                        scanner.nextLine();
                        library.removeBook(removeId);
                        break;
                    case 7:
                        System.out.println("Select category to list books : 1-StudyBook, 2-Journals, 3-Magazines");
                        int cat = scanner.nextInt();
                        scanner.nextLine();
                        if (cat == 1) library.listBooksByCategory(StudyBooks.class);
                        else if (cat == 2) library.listBooksByCategory(Journals.class);
                        else if (cat == 3) library.listBooksByCategory(Magazines.class);
                        else System.out.println("Invalid category selection.");
                        break;
                    case 8:
                        System.out.println("Enter author's name to list all author's books: ");
                        String authorsBook = scanner.nextLine();

                        Author foundAuthor = library.getAuthors().stream()
                                .filter(a -> a.getName().equalsIgnoreCase(authorsBook.trim()))
                                .findFirst()
                                .orElse(null);

                        if (foundAuthor != null) {
                            library.searchBooksByAuthor(library, foundAuthor);
                        } else {
                            System.out.println("Author not found in the library!");
                        }
                        break;

                    case 9:
                        System.out.println("Enter Book Id to borrow a book : ");
                        long borrowBookId=scanner.nextLong();
                        scanner.nextLine();
                        System.out.println("Enter your name : ");
                        String readerName = scanner.nextLine();

                        Reader reader=library.findReaderByName(readerName);


                        if (reader == null) {
                            System.out.println("\n=== Creating New Member ===");
                            System.out.print("Enter member ID: ");
                            long memberId = scanner.nextLong();
                            scanner.nextLine();

                            System.out.print("Enter address: ");
                            String address = scanner.nextLine();

                            System.out.print("Enter phone number: ");
                            String phone = scanner.nextLine();

                            System.out.print("Select member type (1-Regular Reader, 2-Student, 3-Faculty): ");
                            int memberType = scanner.nextInt();
                            scanner.nextLine();

                            MemberRecord newRecord;
              switch (memberType) {
                     case 2 -> {
                                    System.out.print("Student ID: ");
                                    String studentId = scanner.nextLine();
                                    System.out.print("Major: ");
                                    String major = scanner.nextLine();
                                    System.out.print("Year (1-4): ");
                                    int year = scanner.nextInt();
                                    scanner.nextLine();
                                    newRecord = new Student(memberId, "Student", LocalDateTime.now(), 0, 5,
                                            readerName, address, phone, studentId, major, year);
                                }
                     case 3 -> {
                                    System.out.print("Employee ID: ");
                                    String empId = scanner.nextLine();
                                    System.out.print("Department: ");
                                    String dept = scanner.nextLine();
                                    System.out.print("Title (Dr., Prof., etc.): ");
                                    String title = scanner.nextLine();
                                    newRecord = new Faculty(memberId, LocalDateTime.now(), 0,
                                            readerName, address, phone, dept, title, empId);
                                }
                                default -> {
                                    newRecord = new MemberRecord(memberId, "Reader", LocalDateTime.now(),
                                            0, 5, readerName, address, phone);
                                }
                            }

                            reader = new Reader(readerName, newRecord);
                            library.addReader(reader);
                            System.out.println("Reader added: " + readerName);
                        }

                        librarian.issueBook(library, borrowBookId, reader);
                        break;

                    case 10 :
                        System.out.println("Enter reader name who is returning the book: ");
                        String returnReaderName = scanner.nextLine();

                        Reader readerReturn = library.findReaderByName(returnReaderName);

                        if (readerReturn == null) {
                            System.out.println("Reader not found!");
                            break;
                        }

                        System.out.println("Enter Book ID to return: ");
                        long returnId = scanner.nextLong();
                        scanner.nextLine();

                        librarian.returnBook(library, returnId, readerReturn);
                        break;

                    case 11:
                        System.out.println("See all readers in library. ");
                        library.showAllReaders();
                        break;
                    case 12 :
                        System.out.println("See all authors.");
                        library.showAllAuthors();
                        break;
                    case 13:
                        System.out.print("Enter Book ID to update: ");
                        long updateId = scanner.nextLong();
                        scanner.nextLine();

                        Book existingBook = library.getBookById(updateId);
                        if (existingBook == null) {
                            System.out.println("Book not found.");
                            break;
                        }

                        System.out.println("Current details:");
                        existingBook.display();

                        System.out.print("New Name: ");
                        String newName = scanner.nextLine();
                        existingBook.setName(newName);

                        System.out.print("New Price: ");
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine();
                        existingBook.setPrice(newPrice);

                        System.out.print("New Edition: ");
                        String newEdition = scanner.nextLine();
                        existingBook.setEdition(newEdition);

                        if (existingBook instanceof StudyBooks sb) {
                            System.out.print("New Subject: ");
                            sb.setSubject(scanner.nextLine());

                            System.out.print("New Grade Level: ");
                            sb.setGradeLevel(scanner.nextLine());

                        } else if (existingBook instanceof Journals j) {
                            System.out.print("New Publisher: ");
                            j.setPublisher(scanner.nextLine());

                            System.out.print("New Issue Number: ");
                            j.setIssueNumber(scanner.nextInt());
                            scanner.nextLine();

                        } else if (existingBook instanceof Magazines m) {
                            System.out.print("New Topic: ");
                            m.setTopic(scanner.nextLine());

                            System.out.print("New Page Count: ");
                            m.setPageCount(scanner.nextInt());
                            scanner.nextLine();
                        }

                        System.out.println("Book updated successfully!");
                        break;
                    case 14 :
                        System.out.print("Enter member ID to search: ");
                        long searchMemberId = scanner.nextLong();
                        scanner.nextLine();

                        Reader foundReader = null;
                        for (Reader r : library.getReaders()) {
                            if (r.getMemberRecord().getMemberId() == searchMemberId) {
                                foundReader = r;
                                break;
                            }
                        }

                        if (foundReader != null) {
                            System.out.println("\n=== READER FOUND ===");
                            foundReader.whoyouare();
                            System.out.println("\n=== BORROWED BOOKS ===");
                            if (foundReader.getBorrowedBooks().isEmpty()) {
                                System.out.println("No books currently borrowed.");
                            } else {
                                for (Book book : foundReader.getBorrowedBooks()) {
                                    book.display();
                                }
                            }
                        } else {
                            System.out.println("No reader found with ID: " + searchMemberId);
                        }
                        break;
                     case 15:
                     running = false;
                        System.out.println("Exiting Library System. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option! Please select a valid number.");

                }



            }
            scanner.close();
        }
    }