import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GlobalScienceExpo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); 
        int K = scanner.nextInt(); 
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int theme = scanner.nextInt();
            frequencies.put(theme, frequencies.getOrDefault(theme, 0) + 1);
        }
        int numFreq1Themes = 0; 
        int numFreq2Themes = 0; 
        for (int freq : frequencies.values()) {
            switch (freq) {
                case 1:
                    numFreq1Themes++;
                    break;
                case 2:
                    numFreq2Themes++;
                    break;
                default:
                    System.out.println("NO");
                    scanner.close();
                    return;
            }
        }
        if (K <= numFreq2Themes) {
            System.out.println("YES");
        } else {
            int themesNeededFromFreq1 = K - numFreq2Themes;
            if (numFreq1Themes >= 2 * themesNeededFromFreq1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }
}