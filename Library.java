import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Boek toevoegen
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Lid toevoegen
    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member added: " + member.getName());
    }

    // Boek uitlenen
    public void lendBook(String title, int memberId) {
        Book book = findBook(title);
        Member member = findMember(memberId);

        if (book != null && member != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book '" + book.getTitle() + "' lent to " + member.getName());
        } else if (book == null) {
            System.out.println("Book not found.");
        } else if (member == null) {
            System.out.println("Member not found.");
        } else {
            System.out.println("Book is currently not available.");
        }
    }

    // Boek retourneren
    public void returnBook(String title) {
        Book book = findBook(title);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Book '" + book.getTitle() + "' has been returned.");
        } else if (book != null) {
            System.out.println("Book was not borrowed.");
        } else {
            System.out.println("Book not found.");
        }
    }

    // Beschikbare boeken bekijken
    public void showAvailableBooks() {
        System.out.println("Available books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    // Hulpmethoden om boeken en leden te zoeken
    private Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    private Member findMember(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }
}
