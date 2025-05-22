import java.util.Scanner;

public class StockProfitMaximizer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        int maxProfit = findMaxProfit(prices);
        
        System.out.println(maxProfit);
        
        scanner.close();
    }

    public static int findMaxProfit(int[] prices) {
        int maxProfit = 0;

        for (int buyDay = 0; buyDay < prices.length; buyDay++) {
            for (int sellDay = buyDay + 1; sellDay < prices.length; sellDay++) {
                int profit = prices[sellDay] - prices[buyDay];
                if (profit >= 2) {
                    maxProfit = Math.max(maxProfit, profit);
                }
            }
        }

        return maxProfit;
    }
}