import java.util.Scanner;

public class TrappingRainWater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }
        System.out.println(calculateTrappedRainwater(heights));
        scanner.close();
    }
    public static int calculateTrappedRainwater(int[] heights) {
        if (heights == null || heights.length < 3) { 
            return 0;
        }
        int n = heights.length;
        int totalWater = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = heights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }
        rightMax[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }
        for (int i = 0; i < n; i++) {
            int waterAtCurrentPosition = Math.min(leftMax[i], rightMax[i]) - heights[i];
            if (waterAtCurrentPosition > 0) {
                totalWater += waterAtCurrentPosition;
            }
        }

        return totalWater;
    }
}