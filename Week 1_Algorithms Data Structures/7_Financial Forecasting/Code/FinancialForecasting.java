import java.util.*;

public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0)
            return presentValue;

        return calculateFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial amount: ");
        double presentValue = sc.nextDouble();

        System.out.print("Enter annual growth rate as a decimal (e.g., 0.05 for 5%): ");
        double growthRate = sc.nextDouble();

        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("Future Value after %d years: %.2f%n", years, futureValue);

        sc.close();
    }
}
