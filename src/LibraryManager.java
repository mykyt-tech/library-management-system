import java.util.ArrayList;
import java.util.HashMap;

public class LibraryManager {
    private static final HashMap<String, Book> books = new HashMap<>();
    private static final ArrayList<Member> members = new ArrayList<>();

    public static void addNewMember(int id, String name) {
        members.add(new Member(id, name));
    }

    public static void addNewBook(String title, String author, String isbn, int availableCopies) {
        books.put(isbn, new Book(title, author, isbn, availableCopies));
    }

    public static void removeBook(String isbn) {
        for (Member m : members) {
            for (Book b : m.getBorrowedBooks()) {
                if (b.getIsbn().equals(isbn)) {
                    System.out.println("Cannot remove book: currently borrowed by member(" + m.getId() + ").");
                    return;
                }
            }
        }

        books.remove(isbn);
    }

    public static Book searchBookByTitle(String title) {
        for (Book b : books.values()) {
            if (b.getTitle().equals(title)) {
                return new Book(b);
            }
        }

        return null;
    }

    public static Book searchBookByAuthor(String author) {
        for (Book b : books.values()) {
            if (b.getAuthor().equals(author)) {
                return new Book(b);
            }
        }

        return null;
    }

    public static Book searchBookByIsbn(String isbn) {
        for (Book b : books.values()) {
            if (b.getIsbn().equals(isbn)) {
                return new Book(b);
            }
        }

        return null;
    }

    public static boolean borrowBook(String isbn, int id) {
        Book book = books.get(isbn);

        if (book == null) {
            return false;
        }

        for (Member m : members) {
            if (m.getId() == id) {
                for (Book mb : m.getBorrowedBooks()) {
                    if (mb.getIsbn().equals(isbn)) {
                        return false;
                    }
                }

                m.addBook(book);
                book.decreaseAvailableCopies();
                return true;
            }
        }

        return false;
    }

    public static boolean returnBook(String isbn, int id) {
        Book book = books.get(isbn);

        if (book == null) {
            return false;
        }

        for (Member m : members) {
            if (m.getId() == id) {
                m.getBorrowedBooks().removeIf(b -> b.getIsbn().equals(isbn));
                book.increaseAvailableCopies();
                return true;
            }
        }

        return false;
    }

    public static ArrayList<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }
}
