import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class GiftTower {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); 
        scanner.nextLine(); 

        Stack<String> tower = new Stack<>();
        HashMap<String, Integer> frequencies = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String command = parts[0];

            switch (command) {
                case "PUSH":
                    String gift = parts[1];
                    tower.push(gift);
                    frequencies.put(gift, frequencies.getOrDefault(gift, 0) + 1);
                    break;
                case "POP":
                    if (!tower.isEmpty()) {
                        String removedGift = tower.pop();
                        frequencies.put(removedGift, frequencies.get(removedGift) - 1);
                        if (frequencies.get(removedGift) == 0) {
                            frequencies.remove(removedGift);
                        }
                    }
                    break;
                case "COUNT":
                    if (tower.isEmpty()) {
                        System.out.println("EMPTY");
                    } else {
                        String topGift = tower.peek();
                        System.out.println(frequencies.get(topGift));
                    }
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}