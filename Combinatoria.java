import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Combinatoria {
    private static Map<String, Long> memo = new HashMap<>();
    public static long calculateCombinations(int N, int R) {
        if (R == 0 || R == N) {
            return 1;
        }
        if (R < 0 || R > N) {
            return 0;
        }
        String key = N + "," + R;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        long result = calculateCombinations(N - 1, R) + calculateCombinations(N - 1, R - 1);
        memo.put(key, result);
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int R = scanner.nextInt();
        System.out.println(calculateCombinations(N, R));
        scanner.close();
    }
}
