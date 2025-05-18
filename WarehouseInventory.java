import java.util.Scanner;

public class WarehouseInventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of warehouses (r): ");
        int r = scanner.nextInt();
        System.out.print("Enter number of product types (c): ");
        int c = scanner.nextInt();

        int[][] stock = new int[r][c];

        System.out.println("Enter stock levels (row-wise):");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                stock[i][j] = scanner.nextInt();
            }
        }

        int overstockedCount = countOverstockedWarehouses(stock, r, c);

        System.out.println("Number of overstocked warehouses: " + overstockedCount);
    }

    private static int countOverstockedWarehouses(int[][] stock, int r, int c) {
        int count = 0;

        for (int i = 0; i < r; i++) {
            int overstockedProductCount = 0;
            for (int j = 0; j < c; j++) {
                if (stock[i][j] > 100) {
                    overstockedProductCount++;
                }
            }
            if (overstockedProductCount >= 3) {
                count++;
            }
        }
        return count;
    }
}