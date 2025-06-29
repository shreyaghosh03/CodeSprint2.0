import java.util.Scanner;

public class CrystalTransformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] energyLevels = new long[N];
        for (int i = 0; i < N; i++) {
            energyLevels[i] = scanner.nextLong();
        }
        if (N < 2) {
            System.out.println(""); 
            scanner.close();
            return;
        }
        long[] transformedLevels = new long[N];
        long[] prefixProducts = new long[N];
        prefixProducts[0] = 1; 
        for (int i = 1; i < N; i++) {
            prefixProducts[i] = prefixProducts[i - 1] * energyLevels[i - 1];
        }
        long[] suffixProducts = new long[N];
        suffixProducts[N - 1] = 1; 
        for (int i = N - 2; i >= 0; i--) {
            suffixProducts[i] = suffixProducts[i + 1] * energyLevels[i + 1];
        }
        for (int i = 0; i < N; i++) {
            transformedLevels[i] = prefixProducts[i] * suffixProducts[i];
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            result.append(transformedLevels[i]);
            if (i < N - 1) {
                result.append(" ");
            }
        }
        System.out.println(result.toString());
        scanner.close();
    }
}