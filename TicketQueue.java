import java.util.LinkedList;
import java.util.Queue;

public class TicketQueue {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < tickets.length; i++) {
            queue.offer(new int[]{i, tickets[i]});
        }

        int timeElapsed = 0;
        int targetOriginalIndex = k; 

        while (true) {
            int[] currentPerson = queue.poll(); 

            timeElapsed++; 

            currentPerson[1]--; 

            if (currentPerson[0] == targetOriginalIndex && currentPerson[1] == 0) {
                break; 
            }
            if (currentPerson[1] > 0) {
                queue.offer(currentPerson);
            }
        }
        return timeElapsed;
    }
    public static void main(String[] args) {
        TicketQueue solver = new TicketQueue();
        int[] tickets1 = {2, 3, 2};
        int k1 = 2;
        System.out.println("Example 1 Output: " + solver.timeRequiredToBuy(tickets1, k1)); 
    }
}