import java.util.Scanner;

public class PowerCalculator {
    public double power(double x, int n) {
        if (n < 0) {
            if (x == 0) {
                throw new IllegalArgumentException("0 raised to a negative power is undefined.");
            }
            return 1.0 / power(x, -n);
        }
        if (n == 0) {
            return 1.0;
        }
        if (x == 0) {
            return 0.0; 
        }
        double halfPower = power(x, n / 2);
        if (n % 2 == 0) {
            return halfPower * halfPower;
        } else {
            return x * halfPower * halfPower;
        }
    }
    public static void main(String[] args) {
        PowerCalculator calculator = new PowerCalculator();
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        int n = scanner.nextInt();
        System.out.println("Input: x = " + x + ", n = " + n);
        System.out.println("Output: " + calculator.power(x, n)); 
    }
}