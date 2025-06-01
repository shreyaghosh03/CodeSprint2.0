import java.util.Scanner;
import java.util.Stack;

public class PostfixToPrefix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String postfixExpression = scanner.nextLine();
        Stack<String> stack = new Stack<>();

        for (char c : postfixExpression.toCharArray()) {
            if (isOperand(c)) {
                stack.push(String.valueOf(c));
            } else if (isOperator(c)) {
                String op2 = stack.pop();
                String op1 = stack.pop();
                String newPrefixExpression = c + op1 + op2;
                stack.push(newPrefixExpression);
            }
        }
        System.out.println(stack.pop());
        scanner.close();
    }
    private static boolean isOperand(char c) {
        return Character.isLetter(c);
    }
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}