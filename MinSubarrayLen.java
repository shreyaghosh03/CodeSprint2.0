import java.util.Scanner;

public class MinSubarrayLen {

    public static int minSubArrayLen(int target, int[] sessions) {
        int n = sessions.length;
        int minLength = Integer.MAX_VALUE; 
        int windowSum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            windowSum += sessions[right]; 

            while (windowSum >= target) {
                minLength = Math.min(minLength, right - left + 1); 
                windowSum -= sessions[left]; 
                left++; 
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter target: ");
        int target = scanner.nextInt();

        System.out.print("Enter number of sessions (n): ");
        int n = scanner.nextInt();

        int[] sessions = new int[n];
        System.out.println("Enter calories burned in each session:");
        for (int i = 0; i < n; i++) {
            sessions[i] = scanner.nextInt();
        }

        int result = minSubArrayLen(target, sessions);
        System.out.println("Output: " + result);

        scanner.close();
    }
}
