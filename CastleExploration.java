import java.util.*;

public class CastleExploration{
    public static List<Integer> exploreCastles(int n, List<List<Integer>> adj) {
        List<Integer> visitedOrder = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        visitedOrder.add(0);
        while (!queue.isEmpty()) {
            int currentCastle = queue.poll();
            for (int neighbor : adj.get(currentCastle)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    visitedOrder.add(neighbor);
                }
            }
        }
        return visitedOrder;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); 
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            System.out.print("Castle " + i + " neighbors: ");
            String line = scanner.nextLine();
            if (!line.trim().isEmpty()) {
                String[] neighborsStr = line.trim().split(" ");
                for (String neighbor : neighborsStr) {
                    try {
                        adj.get(i).add(Integer.parseInt(neighbor));
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input for neighbor: " + neighbor + ". Please enter integers only.");
                    }
                }
            }
        }
        List<Integer> result = exploreCastles(n, adj);
        System.out.println("Order of visited castles: " + result);
        scanner.close();
    }
}