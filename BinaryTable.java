import java.util.Scanner;

public class BinaryTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); 
        int k = scanner.nextInt(); 
        BinaryTable solver = new BinaryTable(); 
        int result = solver.findChar(n, k); 
        System.out.println(result); 
        scanner.close(); 
    }
    public int findChar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int parentK = (k + 1) / 2;
        int parentChar = findChar(n - 1, parentK);
        if (k % 2 == 1) {
            return parentChar;
        } else {
            return 1 - parentChar; 
        }
    }
}