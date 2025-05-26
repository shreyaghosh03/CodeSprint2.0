import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZigZagAppointmentScheduler {

    public static List<Integer> zigZagReorder(List<Integer> appointments) {
        List<Integer> reordered = new ArrayList<>();
        int start = 0;
        int end = appointments.size() - 1;

        while (start <= end) {
            if (start == end) {
                reordered.add(appointments.get(start));
            } else {
                reordered.add(appointments.get(start));
                reordered.add(appointments.get(end));
            }
            start++;
            end--;
        }
        return reordered;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of appointments:");
        int n = scanner.nextInt();

        List<Integer> appointments = new ArrayList<>();
        System.out.println("Enter the appointment IDs:");
        for (int i = 0; i < n; i++) {
            appointments.add(scanner.nextInt());
        }

        List<Integer> result = zigZagReorder(appointments);
        System.out.println("Zig-Zag Reordered Appointments:");
        for (int id : result) {
            System.out.print(id + " ");
        }
        scanner.close();
    }
}