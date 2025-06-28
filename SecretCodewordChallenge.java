import java.util.Scanner;

public class SecretCodewordChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] words = new String[N];
        int[] masks = new int[N]; 
        for (int i = 0; i < N; i++) {
            words[i] = scanner.nextLine();
            masks[i] = generateBitmask(words[i]);
        }
        long maxStrength = 0; 
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    long currentStrength = (long) words[i].length() * words[j].length();
                    if (currentStrength > maxStrength) {
                        maxStrength = currentStrength;
                    }
                }
            }
        }
        System.out.println(maxStrength);
        scanner.close();
    }
    private static int generateBitmask(String word) {
        int mask = 0;
        for (char c : word.toCharArray()) {
            int bitPos = c - 'a';
            mask |= (1 << bitPos);
        }
        return mask;
    }
}