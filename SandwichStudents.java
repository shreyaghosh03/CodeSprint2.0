import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SandwichStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Queue<Integer> students = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            students.offer(scanner.nextInt());
        }
        Stack<Integer> sandwiches = new Stack<>();
        LinkedList<Integer> tempSandwiches = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            tempSandwiches.add(scanner.nextInt());
        }
        for (int i = n - 1; i >= 0; i--) {
            sandwiches.push(tempSandwiches.get(i));
        }
        System.out.println(countStudentsUnableToEat(students, sandwiches));
        scanner.close();
    }
    public static int countStudentsUnableToEat(Queue<Integer> students, Stack<Integer> sandwiches) {
        int rotations = 0; 
        while (!students.isEmpty() && !sandwiches.isEmpty()) {
            int currentStudentPreference = students.peek();
            int currentSandwich = sandwiches.peek();

            if (currentStudentPreference == currentSandwich) {
                students.poll();
                sandwiches.pop();
                rotations = 0; 
            } else {
                students.offer(students.poll());
                rotations++;
                if (rotations == students.size()) {
                    break;
                }
            }
        }
        return students.size();
    }
}
