import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LargestNumber {
    public static String largestNumber(String[] numbers) {
        Arrays.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String s1s2 = s1 + s2;
                String s2s1 = s2 + s1;
                return s2s1.compareTo(s1s2);
            }
        });
        if (numbers[0].equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (String num : numbers) {
            result.append(num);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); 
        String[] numbers = scanner.nextLine().split(" ");
        System.out.println(largestNumber(numbers));
        scanner.close();
    }
}