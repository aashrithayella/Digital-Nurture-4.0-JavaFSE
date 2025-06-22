public class DecoratorPatternTest {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(emailNotifier);
        System.out.println("Sending notification with Email and SMS:");
        smsNotifier.send("Hello World!");
        System.out.println("\nSending notification with Email and Slack:");
        slackNotifier.send("Hello World!");
        System.out.println("\nSending notification with Email, SMS, and Slack:");
        Notifier combinedNotifier = new SlackNotifierDecorator(smsNotifier);
        combinedNotifier.send("Hello World!");
    }
}