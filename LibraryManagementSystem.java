import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Lend Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show Available Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;
                case 2:
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    library.addMember(new Member(name));
                    break;
                case 3:
                    System.out.print("Enter book title to lend: ");
                    String lendTitle = scanner.nextLine();
                    System.out.print("Enter member ID: ");
                    int memberId = scanner.nextInt();
                    library.lendBook(lendTitle, memberId);
                    break;
                case 4:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 5:
                    library.showAvailableBooks();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
