import java.util.Scanner;

public class BinaryStringSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); 
        String S = scanner.next(); 
        int countZeros = 0;
        for (char c : S.toCharArray()) {
            if (c == '0') {
                countZeros++;
            }
        }
        int misplacedOnesInZeroSection = 0;
        for (int i = 0; i < countZeros; i++) {
            if (S.charAt(i) == '1') {
                misplacedOnesInZeroSection++;
            }
        }
        System.out.println(misplacedOnesInZeroSection);
        scanner.close();
    }
}