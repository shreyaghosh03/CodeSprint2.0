import java.util.Scanner;

public class LongestIncreasingSubarray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] temps = new int[n];

        for (int i = 0; i < n; i++) {
            temps[i] = scanner.nextInt();
        }

        int longestLength = findLongestIncreasingSubarray(temps);

        System.out.println(longestLength);
    }

    private static int findLongestIncreasingSubarray(int[] temps) {
        if (temps.length == 0) {
            return 0;
        }

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < temps.length; i++) {
            if (temps[i] > temps[i - 1]) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1; 
            }
        }
        maxLength = Math.max(maxLength, currentLength);

        return maxLength;
    }
}