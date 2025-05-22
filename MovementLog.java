import java.util.Scanner;

public class MovementLog {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the binary log: ");
        String log = scanner.nextLine();

        int segmentCount = countMovementSegments(log);

        System.out.println("Number of distinct segments of movement: " + segmentCount);
    }

    public static int countMovementSegments(String log) {
        int count = 0;
        int length = log.length();
        
        for (int i = 0; i < length; i++) {
            if (log.charAt(i) == '1') {
                count++;  
                while (i < length && log.charAt(i) == '1') {
                    i++;
                }
            }
        }
        
        return count;
    }
}