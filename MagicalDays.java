import java.util.Scanner;

public class MagicalDays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of days: ");
        int n = scanner.nextInt();

        int[] scores = new int[n];
        System.out.println("Enter the scores for each day: ");
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        int magicalDaysCount = countMagicalDays(scores);

        System.out.println("Number of magical days: " + magicalDaysCount);
    }

    public static int countMagicalDays(int[] scores) {
        int count = 0;

        for (int i = 1; i < scores.length - 1; i++) {
            if (scores[i] > scores[i - 1] && scores[i] > scores[i + 1]) {
                count++;
            }
        }

        return count;
    }
}