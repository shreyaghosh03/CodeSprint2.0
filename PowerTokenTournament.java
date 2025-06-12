import java.util.Arrays;
import java.util.Scanner;

public class PowerTokenTournament {
    public int maximizeScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int currentPower = power;
        int currentScore = 0;
        int maxScore = 0;

        int left = 0;
        int right = tokens.length - 1;

        while (left <= right) {
            if (currentPower >= tokens[left]) {
                currentPower -= tokens[left];
                currentScore++;
                left++;
                maxScore = Math.max(maxScore, currentScore);
            }
            else if (currentScore >= 1 && left < right) {
                currentPower += tokens[right];
                currentScore--;
                right--;
            }
            else {
                break;
            }
        }
        return maxScore;
    }
    public static void main(String[] args) {
        PowerTokenTournament solver = new PowerTokenTournament();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] tokens = new int[n];
        for(int i =0; i<n; i++){
            tokens[i] = scanner.nextInt();
        }
        int power = scanner.nextInt();
        System.out.println("Input: tokens=" + Arrays.toString(tokens) + ", power=" + power + " -> Output: " + solver.maximizeScore(tokens, power)); 
    }
}