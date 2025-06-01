import java.util.Scanner;
import java.util.Stack;

public class StringReverser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        Stack<Character> charStack = new Stack<>();
        for (char c : inputString.toCharArray()) {
            charStack.push(c);
        }
        StringBuilder reversedString = new StringBuilder();
        while (!charStack.isEmpty()) {
            reversedString.append(charStack.pop());
        }
        System.out.println(reversedString.toString());
        scanner.close();
    }
}