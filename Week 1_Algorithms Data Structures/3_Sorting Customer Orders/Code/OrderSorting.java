import java.util.Scanner;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Total Price: $" + totalPrice;
    }
}

public class OrderSorting {

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of orders: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        Order[] orders = new Order[n];

        // Input order details
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Order " + (i + 1) + ":");
            System.out.print("Order ID: ");
            int orderId = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.print("Customer Name: ");
            String customerName = sc.nextLine();

            System.out.print("Total Price: ");
            double totalPrice = sc.nextDouble();

            orders[i] = new Order(orderId, customerName, totalPrice);
        }

        // Show unsorted orders
        System.out.println("\n--- Unsorted Orders ---");
        displayOrders(orders);

        // Apply Bubble Sort
        bubbleSort(orders);
        System.out.println("\n--- Orders Sorted by Bubble Sort (by Total Price) ---");
        displayOrders(orders);

        // Apply Quick Sort
        quickSort(orders, 0, orders.length - 1);
        System.out.println("\n--- Orders Sorted by Quick Sort (by Total Price) ---");
        displayOrders(orders);

        sc.close();
    }

    // Display method
    public static void displayOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // Swap
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    public static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                swap(orders, i, j);
            }
        }
        swap(orders, i + 1, high);
        return i + 1;
    }

    public static void swap(Order[] orders, int i, int j) {
        Order temp = orders[i];
        orders[i] = orders[j];
        orders[j] = temp;
    }
}
