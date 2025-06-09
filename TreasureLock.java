import java.util.Arrays;
import java.util.Scanner;

public class TreasureLock {
    public static boolean findTriplet(int[] stones, int target) {
        int n = stones.length;
        Arrays.sort(stones);
        for (int i = 0; i < n - 2; i++) { 
            int remainingTarget = target - stones[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int currentSum = stones[left] + stones[right];
                if (currentSum == remainingTarget) {
                    return true; 
                } else if (currentSum < remainingTarget) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false; 
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] stones = new int[n];
        for (int i = 0; i < n; i++) {
            stones[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        System.out.println(findTriplet(stones, target));
        scanner.close();
    }
}