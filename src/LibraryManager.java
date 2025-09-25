import java.util.ArrayList;

public class LibraryManager {
    private static final ArrayList<Book> books = new ArrayList<>();
    private static final ArrayList<Member> members = new ArrayList<>();

    public static void addNewMember(int id, String name) {
        members.add(new Member(id, name));
    }
}
