import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MagicalArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        int[] ngeIndex = new int[N]; 
        Arrays.fill(ngeIndex, -1);
        Stack<Integer> stackNGE = new Stack<>(); 
        for (int i = N - 1; i >= 0; i--) {
            while (!stackNGE.isEmpty() && arr[stackNGE.peek()] <= arr[i]) {
                stackNGE.pop();
            }
            if (!stackNGE.isEmpty()) {
                ngeIndex[i] = stackNGE.peek();
            }
            stackNGE.push(i);
        }
        int[] nseIndex = new int[N]; 
        Arrays.fill(nseIndex, -1);
        Stack<Integer> stackNSE = new Stack<>(); 
        for (int i = N - 1; i >= 0; i--) {
            while (!stackNSE.isEmpty() && arr[stackNSE.peek()] >= arr[i]) {
                stackNSE.pop();
            }
            if (!stackNSE.isEmpty()) {
                nseIndex[i] = stackNSE.peek();
            }
            stackNSE.push(i);
        }
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            int currentNGEIdx = ngeIndex[i];
            if (currentNGEIdx == -1) {
                result[i] = -1; 
            } else {
                int nextSmallerAfterNGEIdx = nseIndex[currentNGEIdx];
                if (nextSmallerAfterNGEIdx == -1) {
                    result[i] = -1; 
                } else {
                    result[i] = arr[nextSmallerAfterNGEIdx];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + (i == N - 1 ? "" : " "));
        }
        System.out.println();
    }
}
