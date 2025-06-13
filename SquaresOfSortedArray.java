import java.util.Arrays;
import java.util.Scanner;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);
        return result;
    }
    public static void main(String[] args) {
        SquaresOfSortedArray solver = new SquaresOfSortedArray();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i =0; i<n; i++){
            nums[i] = scanner.nextInt();
        }
        int[] result = solver.sortedSquares(nums);
        System.out.print("Input: [-4, -1, 0, 3, 10], Output: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i == result.length - 1 ? "" : " "));
        }
        System.out.println(); 
    }
}