public class Main {
    public static void main(String args[]) {
        // Get first instance of Logger
        Logger logger1 = Logger.getInstance();

        // Get second instance of Logger
        Logger logger2 = Logger.getInstance();

        // Log messages using both instances
        logger1.log("This is the first message.");
        logger2.log("This is the second message.");

        // Check if both references point to the same object
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 refer to the same instance.");
        } else {
            System.out.println("Different logger instances created!");
        }
    }
}
