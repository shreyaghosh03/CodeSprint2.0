import java.util.Scanner;
import java.util.Stack;

public class SecretMessageDecoder {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = count * 10 + (s.charAt(i) - '0');
                    i++;
                }
                countStack.push(count);
            } else if (currentChar == '[') {
                resultStack.push(result); 
                result = new StringBuilder(); 
                i++;
            } else if (currentChar == ']') {
                StringBuilder temp = result; 
                result = resultStack.pop(); 
                int repeatTimes = countStack.pop(); 

                for (int j = 0; j < repeatTimes; j++) {
                    result.append(temp);
                }
                i++;
            } else {
                result.append(currentChar);
                i++;
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        SecretMessageDecoder decoder = new SecretMessageDecoder();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println("Input: " + s);
        System.out.println("Output: " + decoder.decodeString(s)); 
    }
}