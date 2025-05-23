import java.util.Scanner;

public class SpeechCleaner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the speech line: ");
        String speechLine = scanner.nextLine();
        
        String cleanedSpeech = cleanSpeech(speechLine);
        
        System.out.println("Cleaned Speech: " + cleanedSpeech);
        
        scanner.close();
    }

    public static String cleanSpeech(String speech) {
        String[] words = speech.trim().split("\\s+");
        
        StringBuilder reversedSpeech = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedSpeech.append(words[i]);
            if (i != 0) {
                reversedSpeech.append(" "); 
            }
        }
        
        return reversedSpeech.toString();
    }
}