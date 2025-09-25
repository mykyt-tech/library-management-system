public class Book {
    private String title;
    private String author;
    private String isbn;
    private int availableCopies;

    public Book(String title, String author, String isbn, int availableCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.availableCopies = availableCopies;
    }

    public Book(Book b) {
        this.title = b.getTitle();
        this.author = b.getAuthor();
        this.isbn = b.getIsbn();
        this.availableCopies = b.getAvailableCopies();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void increaseAvailableCopies() {
        availableCopies++;
    }

    public void decreaseAvailableCopies() {
        availableCopies--;
    }
}
