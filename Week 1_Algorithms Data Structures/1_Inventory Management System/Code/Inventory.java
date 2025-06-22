import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    private Map<Integer, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    // Method to add a product
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
        System.out.println("Product added: " + product);
    }

    // Method to update a product
    public void updateProduct(int productId, String productName, int quantity, double price) {
        Product product = products.get(productId);
        if (product != null) {
            product.setProductName(productName);
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product with ID " + productId + " updated.");
        } else {
            System.out.println("Invalid Product ID: " + productId);
        }
    }

    // Method to delete a product
    public boolean deleteProduct(int productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
            System.out.println("Product with ID " + productId + " removed.");
            return true;
        } else {
            System.out.println("Invalid Product ID: " + productId);
            return false;
        }
    }

    // Method to display all products
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : products.values()) {
                System.out.println(product);
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        int productId;
        String productName;
        int quantity;
        double price;

        // Adding products
        char makeEntry = 'y';
        while (makeEntry == 'y') {
            System.out.println("Enter Product Details:");
            System.out.print("Product ID: ");
            productId = sc.nextInt();
            sc.nextLine();
            System.out.print("Product Name: ");
            productName = sc.nextLine();
            System.out.print("Quantity: ");
            quantity = sc.nextInt();
            System.out.print("Price: ");
            price = sc.nextDouble();

            Product product = new Product(productId, productName, quantity, price);
            inventory.addProduct(product);

            System.out.print("Want to add another product [y/n]: ");
            makeEntry = sc.next().charAt(0);
            System.out.println();
        }

        // Displaying products
        System.out.println("Products in inventory:");
        inventory.displayProducts();

        // Updating a product
        System.out.print("\nEnter Product ID to update: ");
        productId = sc.nextInt();
        sc.nextLine();  // clear buffer
        System.out.print("New Product Name: ");
        productName = sc.nextLine();
        System.out.print("New Quantity: ");
        quantity = sc.nextInt();
        System.out.print("New Price: ");
        price = sc.nextDouble();
        inventory.updateProduct(productId, productName, quantity, price);

        // Displaying products after update
        System.out.println("\nProducts in inventory after update:");
        inventory.displayProducts();

        // Deleting a product
        System.out.print("\nEnter Product ID to delete: ");
        productId = sc.nextInt();
        inventory.deleteProduct(productId);

        // Displaying products after deletion
        System.out.println("\nProducts in inventory after deletion:");
        inventory.displayProducts();

        sc.close();
    }
}
