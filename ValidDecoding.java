import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ValidDecoding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        System.out.println(isValidDecoding(s, t));
        scanner.close();
    }
    public static String isValidDecoding(String s, String t) {
        if (s.length() != t.length()) {
            return "False";
        }
        Map<Character, Character> sToTMap = new HashMap<>();
        Map<Character, Character> tToSMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (sToTMap.containsKey(charS)) {
                if (sToTMap.get(charS) != charT) {
                    return "False";
                }
            } else {
                sToTMap.put(charS, charT);
            }
            if (tToSMap.containsKey(charT)) {
                if (tToSMap.get(charT) != charS) {
                    return "False";
                }
            } else {
                tToSMap.put(charT, charS);
            }
        }
        return "True";
    }
}