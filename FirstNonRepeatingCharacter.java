import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static String findFirstNonRepeating(String s) {
        LinkedHashMap<Character, Integer> charCount = new LinkedHashMap<>();
        HashSet<Character> repeatingChars = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (repeatingChars.contains(c)) {
            } else {
                if (charCount.containsKey(c)) {
                    charCount.remove(c);
                    repeatingChars.add(c);
                } else {
                    charCount.put(c, 1);
                }
            }
            if (charCount.isEmpty()) {
                result.append('#');
            } else {
                result.append(charCount.entrySet().iterator().next().getKey());
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println("Input: " + s);
        System.out.println("Output: " + findFirstNonRepeating(s)); 
    }
}