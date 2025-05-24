import java.util.*;

public class AnagramFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String logStream = scanner.nextLine(); 
        String pattern = scanner.nextLine(); 
        
        List<Integer> result = findAnagramIndices(logStream, pattern);
        
        System.out.println(result);
    }

    public static List<Integer> findAnagramIndices(String logStream, String pattern) {
        List<Integer> indices = new ArrayList<>();
        int patternLength = pattern.length();
        int logStreamLength = logStream.length();
        
        int[] patternCount = new int[26];
        for (char c : pattern.toCharArray()) {
            patternCount[c - 'a']++;
        }

        int[] windowCount = new int[26];
        for (int i = 0; i < logStreamLength; i++) {

            windowCount[logStream.charAt(i) - 'a']++;

            if (i >= patternLength) {
                windowCount[logStream.charAt(i - patternLength) - 'a']--;
            }

            if (Arrays.equals(patternCount, windowCount)) {
                indices.add(i - patternLength + 1);
            }
        }
        
        return indices;
    }
}