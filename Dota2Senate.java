import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.add(i);
            } else {
                direQueue.add(i);
            }
        }
        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            int rIndex = radiantQueue.poll(); 
            int dIndex = direQueue.poll();   

            if (rIndex < dIndex) {
                radiantQueue.add(rIndex + n);
            } else {
                direQueue.add(dIndex + n);
            }
        }
        if (!radiantQueue.isEmpty()) {
            return "Radiant";
        } else {
            return "Dire";
        }
    }
    public static void main(String[] args) {
        Dota2Senate solver = new Dota2Senate();
        Scanner scanner = new Scanner(System.in);
        String senate = scanner.nextLine();
        System.out.println("Input: " + senate + ", Output: " + solver.predictPartyVictory(senate)); 
    }
}