import java.util.Scanner;

public class DecodedMessage {

    public static String decode(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                balance++;
            } else { 
                balance--;
            }
            if (balance == 0) {
                result.append(s.substring(start + 1, i));
                start = i + 1;
            }
        }

        return result.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a valid parentheses string:");
        String s = scanner.nextLine();
        scanner.close();

        String decodedMessage = decode(s);
        System.out.println("Decoded Message: " + decodedMessage);
    }
}