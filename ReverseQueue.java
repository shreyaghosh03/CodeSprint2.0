import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReverseQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> queue = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
        }
        Collections.reverse(queue);
        for (int i = 0; i < queue.size(); i++) {
            System.out.print(queue.get(i));
            if (i < queue.size() - 1) {
                System.out.print(" "); 
            }
        }
        System.out.println(); 
        scanner.close();
    }
}