import java.util.Scanner;

public class LetterGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt(); 
        String currentString = "a"; 
        while (currentString.length() < k) {
            StringBuilder nextString = new StringBuilder();
            for (char c : currentString.toCharArray()) {
                char nextChar = (char) (c + 1);
                if (nextChar > 'z') {
                    nextChar = 'a'; 
                }
                nextString.append(nextChar);
            }
            currentString += nextString.toString();
        }
        char result = currentString.charAt(k - 1);
        System.out.println(Character.toUpperCase(result));
        scanner.close();
    }
}