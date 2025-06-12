import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RearrangeString {
    static class CharFrequency {
        char character;
        int frequency;
        public CharFrequency(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }
    }
    public String reorganizeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        for (int freq : freqMap.values()) {
            if (freq > (s.length() + 1) / 2) {
                return "";
            }
        }
        PriorityQueue<CharFrequency> pq = new PriorityQueue<>(
            (a, b) -> b.frequency - a.frequency 
        );
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.add(new CharFrequency(entry.getKey(), entry.getValue()));
        }
        StringBuilder result = new StringBuilder();
        while (pq.size() >= 2) {
            CharFrequency cf1 = pq.poll();
            CharFrequency cf2 = pq.poll();
            result.append(cf1.character);
            result.append(cf2.character);
            cf1.frequency--;
            cf2.frequency--;
            if (cf1.frequency > 0) {
                pq.add(cf1);
            }
            if (cf2.frequency > 0) {
                pq.add(cf2);
            }
        }
        if (!pq.isEmpty()) {
            CharFrequency lastChar = pq.poll();
            if (lastChar.frequency > 1) {
                return ""; 
            }
            result.append(lastChar.character);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        RearrangeString rs = new RearrangeString();
        Scanner scanner =  new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println("Input: \"" + s + "\" Output: \"" + rs.reorganizeString(s) + "\""); 
    }
}