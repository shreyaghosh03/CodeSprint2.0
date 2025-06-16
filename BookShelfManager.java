import java.util.Arrays; 
import java.util.Scanner;
class BookShelfManager {
    public int findInsertionPosition(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; 
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else { 
                high = mid - 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        BookShelfManager manager = new BookShelfManager();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i =0; i<n; i++){
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        System.out.println("Input nums: " + Arrays.toString(nums) + ", Target: " + target +
            " -> Output: " + manager.findInsertionPosition(nums, target));

    }
}