import java.util.HashMap;
import java.util.Scanner;

public class PacketNesting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); 
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        int maxFrequency = 0; 
        for (int i = 0; i < N; i++) {
            int highness = scanner.nextInt();
            frequencies.put(highness, frequencies.getOrDefault(highness, 0) + 1);
            if (frequencies.get(highness) > maxFrequency) {
                maxFrequency = frequencies.get(highness);
            }
        }
        System.out.println(maxFrequency);
        scanner.close();
    }
}