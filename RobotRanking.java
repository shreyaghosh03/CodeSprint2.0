import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RobotRanking {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[][] indexedScores = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexedScores[i][0] = score[i];
            indexedScores[i][1] = i;        
        }
        Arrays.sort(indexedScores, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[0] - a[0]; 
            }
        });
        String[] ranks = new String[n];

        for (int i = 0; i < n; i++) {
            int originalIndex = indexedScores[i][1];
            int rank = i + 1; 

            switch (rank) {
                case 1:
                    ranks[originalIndex] = "Gold Medal";
                    break;
                case 2:
                    ranks[originalIndex] = "Silver Medal";
                    break;
                case 3:
                    ranks[originalIndex] = "Bronze Medal";
                    break;
                default:
                    ranks[originalIndex] = String.valueOf(rank);
                    break;
            }
        }
        return ranks;
    }
    public static void main(String[] args) {
        RobotRanking solver = new RobotRanking();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] score = new int[n];
        for(int i = 0; i<n; i++){
            score[i] = scanner.nextInt();
        }
        String[] ranks = solver.findRelativeRanks(score);
        System.out.println("Scores: " + Arrays.toString(score));
        System.out.println("Ranks: " + Arrays.toString(ranks)); 
    }
}