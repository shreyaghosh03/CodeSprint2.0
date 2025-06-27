import java.util.*;

public class CastleDFSExploration {
    private static void dfs(int n, List<List<Integer>> adj, boolean[] visited, List<Integer> visitedOrder, int currentCastle) {
        visited[currentCastle] = true;
        visitedOrder.add(currentCastle);
        for (int neighbor : adj.get(currentCastle)) {
            if (!visited[neighbor]) {
                dfs(n, adj, visited, visitedOrder, neighbor);
            }
        }
    }
    public static List<Integer> exploreCastlesDFS(int n, List<List<Integer>> adj) {
        List<Integer> visitedOrder = new ArrayList<>();
        boolean[] visited = new boolean[n]; 
        dfs(n, adj, visited, visitedOrder, 0);
        return visitedOrder;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of castles (n): ");
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
                        System.err.println("Invalid input for neighbor: '" + neighbor + "'. Please enter integers only.");
                    }
                }
            }
        }
        List<Integer> result = exploreCastlesDFS(n, adj);
        System.out.println("Order of visited castles (DFS): " + result);
        scanner.close();
    }
}