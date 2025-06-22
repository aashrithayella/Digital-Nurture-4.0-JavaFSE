import java.util.Scanner;

public class TaskManagementSystem {
    private static Node head;

    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Task Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task by ID");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    searchTaskById(scanner);
                    break;
                case 3:
                    traverseTasks();
                    break;
                case 4:
                    deleteTaskById(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter task status: ");
        String status = scanner.nextLine();

        Task newTask = new Task(id, name, status);
        Node newNode = new Node(newTask);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Task added successfully.");
    }

    private static void searchTaskById(Scanner scanner) {
        System.out.print("Enter task ID to search: ");
        String id = scanner.nextLine();

        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId().equals(id)) {
                System.out.println("Task found: " + temp.task);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found.");
    }

    private static void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        System.out.println("Task List:");
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    private static void deleteTaskById(Scanner scanner) {
        System.out.print("Enter task ID to delete: ");
        String id = scanner.nextLine();

        if (head == null) {
            System.out.println("No tasks to delete.");
            return;
        }

        if (head.task.getTaskId().equals(id)) {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }

        Node temp = head;
        while (temp.next != null && !temp.next.task.getTaskId().equals(id)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }
}