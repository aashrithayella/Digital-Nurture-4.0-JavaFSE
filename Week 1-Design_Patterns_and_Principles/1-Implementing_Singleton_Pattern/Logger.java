public class Logger {
    // Single instance of Logger
    private static Logger singleInstance;

    // Private constructor to prevent instantiation
    private Logger() {
        System.out.println("Logger initialized");
    }

    // Returns the single instance (thread-safe)
    public static Logger getInstance() {
        if (singleInstance == null) { // First check
            synchronized (Logger.class) { // Lock
                if (singleInstance == null) { // Second check
                    singleInstance = new Logger();
                }
            }
        }
        return singleInstance;
    }

    // Prints the log message
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
