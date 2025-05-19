import java.util.Scanner;

public class ZigZagWaveChart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of days (n): ");
        int n = scanner.nextInt();
        
        
        if (n > 10) {
            System.out.println("Abhik's marathon journey intensifies! Let's see his progress:");
        }

        int totalNumbers =0;

        for (int day = 1; day <= n; day++) {

            int spacesBefore = (n - day) * 4;

            for (int i = 0; i < spacesBefore; i++) {
                System.out.print(" ");
            }

            if (day % 2 != 0) { 
                for (int i = 1; i <= day; i++) {
                    System.out.print(i + " ");
                    if (i < day) {
                        System.out.print("   "); 
                    }
                    totalNumbers++;
                }
            } else { 
                for (int i = day; i >= 1; i--) {
                    System.out.print(i + " ");
                    if (i > 1) {
                        System.out.print("   "); 
                    }
                    totalNumbers++;
                }
            }
            System.out.println();
        }
        System.out.println("Total numbers printed: " + totalNumbers);

        scanner.close();
    }
}