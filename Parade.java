import java.util.Arrays;
import java.util.Scanner; 
class MissingBadgeFinder {
    public int findMissingNumber(int[] nums) {
        int n = nums.length;
        long expectedSum = (long) n * (n + 1) / 2;
        long actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return (int) (expectedSum - actualSum);
    }
    public static void main(String[] args) {
        MissingBadgeFinder finder = new MissingBadgeFinder();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i =0; i<n; i++){
            nums[i] = scanner.nextInt();
        }
        System.out.println("Input: " + Arrays.toString(nums) + ", Missing number: " + finder.findMissingNumber(nums)); 
    }
}