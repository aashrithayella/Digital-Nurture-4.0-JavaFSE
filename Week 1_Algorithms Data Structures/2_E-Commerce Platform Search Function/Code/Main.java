import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product("1", "Pen", "Stationery"),
            new Product("2", "Notebook", "Stationery"),
            new Product("3", "Bottle", "Kitchenware"),
            new Product("4", "Backpack", "Travel"),
            new Product("5", "Headphones", "Electronics")
        };

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product name to search:");
        String productName = scanner.nextLine();

        System.out.println("Choose search method:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        int choice = scanner.nextInt();

        Product result = null;
        switch (choice) {
            case 1:
                result = LinearSearch.linearSearch(products, productName);
                break;
            case 2:
                result = BinarySearch.binarySearch(products, productName);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        if (result != null) {
           System.out.println("Product found:");
           System.out.println("ID: " + result.productId);
           System.out.println("Name: " + result.productName);
           System.out.println("Category: " + result.category);
        } else {
           System.out.println("Product not found.");
        }

        scanner.close();
    }
}
