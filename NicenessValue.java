import java.util.ArrayList;
import java.util.Scanner;

public class NicenessValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); 
        scanner.nextLine(); 
        ArrayList<String> processedWords = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String currentWord = scanner.nextLine(); 
            int nicenessValue = 0;
            for (String previousWord : processedWords) {
                if (previousWord.compareTo(currentWord) < 0) {
                    nicenessValue++;
                }
            }
            System.out.println(nicenessValue); 
            processedWords.add(currentWord); 
        }
        scanner.close();
    }
}

