import java.util.Scanner;

public class PowerOfTwoChecker {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 0 || n % 2 != 0) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }
    public static void main(String[] args) {
        PowerOfTwoChecker checker = new PowerOfTwoChecker();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Input: n = " + n);
        System.out.println("Output: " + checker.isPowerOfTwo(n)); 
    }
}