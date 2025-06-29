import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FractionCalculator {
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a); 
    }
    private static String simplifyFraction(long numerator, long denominator) {
        if (numerator == 0) {
            return "0/1";
        }
        long commonDivisor = gcd(numerator, denominator);
        numerator /= commonDivisor;
        denominator /= commonDivisor;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        return numerator + "/" + denominator;
    }
    public static String calculateFractions(String formula) {
        long currentNumerator = 0;
        long currentDenominator = 1;
        Pattern pattern = Pattern.compile("([+-]?)(\\d+)/(\\d+)");
        Matcher matcher = pattern.matcher(formula);
        boolean firstFraction = true;
        while (matcher.find()) {
            String signStr = matcher.group(1);
            long numerator = Long.parseLong(matcher.group(2));
            long denominator = Long.parseLong(matcher.group(3));
            int sign = 1; 
            if (!firstFraction) { 
                if (signStr.equals("-")) {
                    sign = -1;
                }
            } else {
                if (formula.startsWith("-") && matcher.start() == 0) {
                    sign = -1;
                }
            }
            if (firstFraction) {
                currentNumerator = sign * numerator;
                currentDenominator = denominator;
                firstFraction = false;
            } else {
                long commonDenominator = currentDenominator * denominator;
                currentNumerator = (currentNumerator * denominator) + (sign * numerator * currentDenominator);
                currentDenominator = commonDenominator;
            }
        }
        return simplifyFraction(currentNumerator, currentDenominator);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String result = calculateFractions(userInput);
        System.out.println("Result: " + result);
        scanner.close(); 
    }
}