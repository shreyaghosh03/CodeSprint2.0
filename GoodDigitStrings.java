import java.util.Scanner;

public class GoodDigitStrings {
    public long countGoodStrings(int n) {
        long MOD = 1_000_000_007; 
        if (n == 0) {
            return 1; 
        }
        long evenChoices = 5; 
        long oddChoices = 4;  
        long numEvenPositions = (n + 1) / 2; 
        long numOddPositions = n / 2;         
        long result = power(evenChoices, numEvenPositions, MOD);
        result = (result * power(oddChoices, numOddPositions, MOD)) % MOD;
        return result;
    }
    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) { 
                res = (res * base) % mod;
            }
            base = (base * base) % mod; 
            exp /= 2;              
        }
        return res;
    }
    public static void main(String[] args) {
        GoodDigitStrings solver = new GoodDigitStrings();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Input n = " + n + ", Output: " + solver.countGoodStrings(n)); 
    }
}