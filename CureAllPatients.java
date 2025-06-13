import java.util.Arrays;
import java.util.Scanner;

public class CureAllPatients {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] vaccines = new int[N];
        for (int i = 0; i < N; i++) {
            vaccines[i] = scanner.nextInt();
        }
        int[] patients = new int[N];
        for (int i = 0; i < N; i++) {
            patients[i] = scanner.nextInt();
        }
        Arrays.sort(vaccines);
        Arrays.sort(patients);
        boolean possibleToCureAll = true;
        for (int i = 0; i < N; i++) {
            if (vaccines[i] <= patients[i]) {
                possibleToCureAll = false;
                break; 
            }
        }
        if (possibleToCureAll) {
            System.out.println("yes");
        } else {
            System.out.println("No");
        }
        scanner.close();
    }
}