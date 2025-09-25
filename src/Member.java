import java.util.ArrayList;

public class Member {
    private int id;
    private String name;
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }

    public void addBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBook(String isbn) {
        borrowedBooks.removeIf(b -> b.getIsbn().equals(isbn));
    }
}
