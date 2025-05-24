import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlagiarismDetector {
    static final int PRIME = 101; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine(); 
        String pattern = scanner.nextLine(); 
        List<Integer> result = findPatternIndices(text, pattern);
        
        System.out.println("Starting indices of pattern in text: " + result);
    }

    public static List<Integer> findPatternIndices(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();
        List<Integer> indices = new ArrayList<>();

        if (patternLength > textLength) {
            return indices; 
        }

        long patternHash = computeHash(pattern, patternLength);
        long textHash = computeHash(text, patternLength);

        for (int i = 0; i <= textLength - patternLength; i++) {
            if (patternHash == textHash) {
                if (text.substring(i, i + patternLength).equals(pattern)) {
                    indices.add(i); 
                }
            }
            if (i < textLength - patternLength) {
                textHash = rollHash(text, textHash, i, patternLength);
            }
        }

        return indices;
    }

    private static long computeHash(String str, int length) {
        long hash = 0;
        for (int i = 0; i < length; i++) {
            hash += (str.charAt(i) * Math.pow(PRIME, i));
        }
        return hash;
    }

    private static long rollHash(String text, long oldHash, int oldIndex, int patternLength) {
        long newHash = oldHash - text.charAt(oldIndex);
        newHash /= PRIME;
        newHash += text.charAt(oldIndex + patternLength) * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }
}
