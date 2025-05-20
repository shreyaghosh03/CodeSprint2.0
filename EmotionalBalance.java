import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmotionalBalance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        scanner.close();
        
        if (isEmotionallyBalanced(input)) {
            System.out.println("Aashriya smiles: Emotional balance found");
        } else {
            System.out.println("Aashriya wonders: These thoughts were scattered");
        }
    }

    public static boolean isEmotionallyBalanced(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        int frequency = charCountMap.values().iterator().next();

        for (int count : charCountMap.values()) {
            if (count != frequency) {
                return false;
            }
        }

        return true;
    }
}