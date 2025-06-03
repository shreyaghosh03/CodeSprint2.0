import java.util.Scanner;
import java.util.Stack;

public class TemperatureTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); 
        scanner.nextLine(); 

        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String operation = parts[0];

            switch (operation) {
                case "PUSH":
                    int temperature = Integer.parseInt(parts[1]);
                    mainStack.push(temperature);
                    if (minStack.isEmpty() || temperature <= minStack.peek()) {
                        minStack.push(temperature);
                    } else {
                        minStack.push(minStack.peek()); 
                    }
                    break;
                case "POP":
                    if (!mainStack.isEmpty()) {
                        mainStack.pop();
                        minStack.pop();
                    }
                    break;
                case "MIN":
                    if (minStack.isEmpty()) {
                        System.out.println("EMPTY");
                    } else {
                        System.out.println(minStack.peek());
                    }
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}