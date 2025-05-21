import java.util.HashSet;
import java.util.Scanner;

public class JewelStoneCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the types of jewels: ");
        String jewels = scanner.nextLine(); 
        
        System.out.print("Enter the stones: ");
        String stones = scanner.nextLine(); 

        int jewelCount = countJewels(jewels, stones);

        System.out.println("Number of jewels in the stones: " + jewelCount);
    }

    private static int countJewels(String jewels, String stones) {
        HashSet<Character> jewelSet = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            jewelSet.add(jewel);
        }

        int count = 0;
        for (char stone : stones.toCharArray()) {
            if (jewelSet.contains(stone)) {
                count++;
            }
        }

        return count;
    }
}