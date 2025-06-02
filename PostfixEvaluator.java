import java.util.Stack;

public class PostfixEvaluator {
    public int evaluatePostfix(String[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (String s : arr) {
            if (s.equals("+")) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1 + op2);
            } else if (s.equals("-")) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1 - op2);
            } else if (s.equals("*")) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1 * op2);
            } else if (s.equals("/")) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                if (op2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                stack.push(op1 / op2);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        PostfixEvaluator evaluator = new PostfixEvaluator();
        String[] expr1 = {"2", "3", "1", "*", "+", "9", "-"};
        System.out.println("Expression 1: " + String.join(" ", expr1) + " = " + evaluator.evaluatePostfix(expr1)); // Expected: -4
    }
}