import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class BeautifulArrangements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); 
        HashSet<Integer> uniqueCards = new HashSet<>();
        for (int i = 0; i < N; i++) {
            uniqueCards.add(scanner.nextInt()); 
        }
        ArrayList<Integer> distinctNumbers = new ArrayList<>(uniqueCards);

        int beautifulArrangementsCount = 0;

        for (int i = 0; i < distinctNumbers.size(); i++) {
            for (int j = 0; j < distinctNumbers.size(); j++) {
                int firstNumber = distinctNumbers.get(i);
                int lastNumber = distinctNumbers.get(j);

                if (firstNumber > lastNumber) {
                    beautifulArrangementsCount++;
                }
            }
        }
        System.out.println(beautifulArrangementsCount);
        scanner.close();
    }
}