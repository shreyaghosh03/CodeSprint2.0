import java.util.Scanner;

public class UniqueBSTs {
    public long numTrees(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of nodes cannot be negative.");
        }
        long[] dp = new long[n + 1];
        dp[0] = 1; 
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        UniqueBSTs solver = new UniqueBSTs();
        long result = solver.numTrees(n);
        System.out.println(result);
        scanner.close();
    }
}