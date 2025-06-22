import java.util.Scanner;

public class MVCPatternTest {
    public static void main(String[] args) {
        Student model = new Student("John Doe", 1, "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        System.out.println("Initial Student Details:");
        controller.updateView();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter new student name:");
        String name = scanner.nextLine();
        controller.setStudentName(name);
        System.out.println("Enter new student ID:");
        int id = scanner.nextInt();
        controller.setStudentId(id);
        scanner.nextLine();
        System.out.println("Enter new student grade:");
        String grade = scanner.nextLine();
        controller.setStudentGrade(grade);
        System.out.println("\nUpdated Student Details:");
        controller.updateView();
        scanner.close();
    }
}