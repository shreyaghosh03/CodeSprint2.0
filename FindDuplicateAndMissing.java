import java.util.Arrays;
import java.util.Scanner;

public class FindDuplicateAndMissing {
    public int[] findMissingAndDuplicate(int[] nums) {
        int n = nums.length;
        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSumOfSquares = (long) n * (n + 1) * (2L * n + 1) / 6;
        long actualSum = 0;
        long actualSumOfSquares = 0;
        for (int num : nums) {
            actualSum += num;
            actualSumOfSquares += (long) num * num;
        }
        long diffSum = actualSum - expectedSum;
        long diffSumOfSquares = actualSumOfSquares - expectedSumOfSquares;
        long sumDM = diffSumOfSquares / diffSum; 
        int duplicated = (int) ((diffSum + sumDM) / 2);
        int missing = (int) ((sumDM - diffSum) / 2);
        return new int[]{duplicated, missing};
    }
    public static void main(String[] args) {
        FindDuplicateAndMissing solver = new FindDuplicateAndMissing();
        Scanner scanner =  new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i =0; i<n; i++){
            nums[i] = scanner.nextInt();
        }
        int[] result = solver.findMissingAndDuplicate(nums);
        System.out.println("Input: " + Arrays.toString(nums) + ", Output: " + Arrays.toString(result)); 
    }
}