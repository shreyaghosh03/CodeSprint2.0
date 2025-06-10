import java.util.Scanner;

public class WarpDriveCalibration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] crystals = new int[n];
        for (int i = 0; i < n; i++) {
            crystals[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        scanner.close();

        int minDiff = Integer.MAX_VALUE;
        int optimalSum = 0; 

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int currentSum = crystals[i] + crystals[j] + crystals[k];
                    int currentDiff = Math.abs(target - currentSum);

                    if (currentDiff < minDiff) {
                        minDiff = currentDiff;
                        optimalSum = currentSum;
                    } 
                    else if (currentDiff == minDiff) {
                        optimalSum = Math.max(optimalSum, currentSum);
                    }
                }
            }
        }
        System.out.println(optimalSum);
    }
}