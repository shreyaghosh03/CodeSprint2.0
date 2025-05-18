import java.util.Scanner;

public class TrafficMonitoring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the total number of hours: ");
        int n = scanner.nextInt();
        
        if (n <= 1) {
            System.out.println("The number of hours must be greater than 1.");
            return;
        }
        
        int[] vehicleCounts = new int[n];
    
        System.out.println("Enter the number of vehicles for each hour:");
        for (int i = 0; i < n; i++) {
            vehicleCounts[i] = scanner.nextInt();
        }

        System.out.println("Critical Jam Hours:");
        for (int i = 1; i < n; i++) {
            if (vehicleCounts[i] >= 50 && vehicleCounts[i] > vehicleCounts[i - 1]) {
                System.out.println("Hour " + (i+1) + ": " + vehicleCounts[i] + " vehicles");
            }
        }

        scanner.close();
    }
}