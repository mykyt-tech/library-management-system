import java.util.ArrayList;

public class LibraryManager {
    private static final ArrayList<Book> books = new ArrayList<>();
    private static final ArrayList<Member> members = new ArrayList<>();

    public static void addNewMember(int id, String name) {
        members.add(new Member(id, name));
    }

    public static void addNewBook(String title, String author, String isbn, int availableCopies) {
        books.add(new Book(title, author, isbn, availableCopies));
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

        books.removeIf(b -> b.getIsbn().equals(isbn));
    }

    public static Book searchBookByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                return new Book(b);
            }
        }

        return null;
    }

    public static Book searchBookByAuthor(String author) {
        for (Book b : books) {
            if (b.getAuthor().equals(author)) {
                return new Book(b);
            }
        }

        return null;
    }

    public static Book searchBookByIsbn(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                return new Book(b);
            }
        }

        return null;
    }
}
