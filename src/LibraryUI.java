import java.util.ArrayList;
import java.util.Scanner;

public class LibraryUI {
    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("-----------------------------");
            System.out.println("Please choose an option:");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Search book");
            System.out.println("4. Borrow book");
            System.out.println("5. Return book");
            System.out.println("6. List all books");
            System.out.println("7. Exit");
            System.out.println("-----------------------------");
            System.out.print("Enter your choice: ");

            int option = sc.nextInt();
            sc.nextLine();

            int memberId;
            String isbn;
            String title;
            String author;
            int availableCopies;

            switch (option) {
                case 1:
                    System.out.println("-----------------------------");
                    System.out.print("Enter title: ");
                    title = sc.nextLine();

                    System.out.print("Enter author: ");
                    author = sc.nextLine();

                    System.out.print("Enter isbn: ");
                    isbn = sc.nextLine();

                    System.out.print("Enter the number of available copies: ");
                    availableCopies = sc.nextInt();
                    sc.nextLine();

                    boolean added = LibraryManager.addNewBook(title, author, isbn, availableCopies);
                    System.out.println("-----------------------------");

                    if (added) {
                        System.out.println("New book successfully added");
                    } else {
                        System.out.println("Something went wrong");
                        System.out.println("(ISBN must be unique for each book)");
                    }

                    break;
                case 2:
                    System.out.println("-----------------------------");
                    System.out.print("Enter isbn: ");
                    isbn = sc.nextLine();

                    LibraryManager.removeBook(isbn);
                    break;
                case 3:
                    int searchBy;

                    System.out.println("-----------------------------");
                    System.out.println("Search book by:");
                    System.out.println("1. title");
                    System.out.println("2. author");
                    System.out.println("3. isbn");

                    searchBy = sc.nextInt();
                    sc.nextLine();

                    Book book = null;

                    switch (searchBy) {
                        case 1:
                            System.out.println("-----------------------------");
                            System.out.print("Enter title: ");
                            title = sc.nextLine();

                            book = LibraryManager.searchBookByTitle(title);
                            break;
                        case 2:
                            System.out.println("-----------------------------");
                            System.out.print("Enter author: ");
                            author = sc.nextLine();

                            book = LibraryManager.searchBookByAuthor(author);
                            break;
                        case 3:
                            System.out.println("-----------------------------");
                            System.out.print("Enter isbn: ");
                            isbn = sc.nextLine();

                            book = LibraryManager.searchBookByIsbn(isbn);
                            break;
                        default:
                            System.out.println("-----------------------------");
                            System.out.println("Incorrect option!");
                    }

                    if (book == null) {
                        System.out.println("-----------------------------");
                        System.out.println("Something went wrong");
                        break;
                    }

                    System.out.println("-----------------------------");
                    System.out.println("ISBN: " + book.getIsbn());
                    System.out.println("Title: " + book.getTitle());
                    System.out.println("Author: " + book.getAuthor());
                    System.out.println("Available copies: " + book.getAvailableCopies());
                    break;
                case 4:
                    System.out.println("-----------------------------");
                    System.out.print("Enter ISBN: ");
                    isbn = sc.nextLine();

                    System.out.print("Enter member ID: ");
                    memberId = sc.nextInt();
                    sc.nextLine();

                    boolean borrowed = LibraryManager.borrowBook(isbn, memberId);
                    System.out.println("-----------------------------");

                    if (borrowed) {
                        System.out.println("Book successfully borrowed");
                    } else {
                        System.out.println("Something went wrong");
                    }

                    break;
                case 5:
                    System.out.println("-----------------------------");
                    System.out.print("Enter ISBN: ");
                    isbn = sc.nextLine();

                    System.out.print("Enter member ID: ");
                    memberId = sc.nextInt();
                    sc.nextLine();

                    boolean returned = LibraryManager.returnBook(isbn, memberId);
                    System.out.println("-----------------------------");

                    if (returned) {
                        System.out.println("Book successfully returned");
                    } else {
                        System.out.println("Something went wrong");
                    }

                    break;
                case 6:
                    ArrayList<Book> books = LibraryManager.getAllBooks();

                    for (Book b : books) {
                        System.out.println("-----------------------------");
                        System.out.println("ISBN: " + b.getIsbn());
                        System.out.println("Title: " + b.getTitle());
                        System.out.println("Author: " + b.getAuthor());
                        System.out.println("Available copies: " + b.getAvailableCopies());
                    }

                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("-----------------------------");
                    System.out.println("Incorrect option!");
            }
        }
    }
}
