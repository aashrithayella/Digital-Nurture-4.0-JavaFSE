import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    private static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Predefined book list
        books.add(new Book("1", "Java Programming", "John Doe"));
        books.add(new Book("2", "Data Structures", "Jane Smith"));
        books.add(new Book("3", "Algorithms", "Jim Brown"));

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Search Book by Title (Linear Search)");
            System.out.println("2. Search Book by Title (Binary Search)");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (option) {
                case 1:
                    System.out.print("Enter book title to search (Linear): ");
                    String linearTitle = scanner.nextLine();
                    int linearIndex = linearSearch(linearTitle);
                    if (linearIndex != -1) {
                        System.out.println("Book found: " + books.get(linearIndex));
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter book title to search (Binary): ");
                    String binaryTitle = scanner.nextLine();
                    books.sort((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle())); // Sort before binary search
                    int binaryIndex = binarySearch(binaryTitle);
                    if (binaryIndex != -1) {
                        System.out.println("Book found: " + books.get(binaryIndex));
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // 🔍 Linear Search Method
    private static int linearSearch(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    // 🔍 Binary Search Method
    private static int binarySearch(String title) {
        int left = 0, right = books.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books.get(mid).getTitle().compareToIgnoreCase(title);
            if (comparison == 0) return mid;
            if (comparison < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
