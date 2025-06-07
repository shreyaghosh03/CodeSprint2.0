import java.util.Arrays;

public class DungeonPath {
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int maxPrevScore = Integer.MIN_VALUE;

            for (int j = Math.max(0, i - k); j < i; j++) {
                maxPrevScore = Math.max(maxPrevScore, dp[j]);
            }
            dp[i] = nums[i] + maxPrevScore;
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        DungeonPath solver = new DungeonPath();
        int[] nums1 = {1, -2, -5, 7, -6, 4};
        int k1 = 2;
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + solver.maxScore(nums1, k1)); 
    }
}