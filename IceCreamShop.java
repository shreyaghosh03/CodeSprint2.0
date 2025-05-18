import java.util.Scanner;

public class IceCreamShop {
    public static boolean canBuyIceCream(int budget, int[] iceCreamPrices) {
        for (int price :  iceCreamPrices) {
            if (price == budget) {
                return true; 
            }
        }
        return false; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the budget: ");
        int budget = scanner.nextInt();

        int[] iceCreamPrices = {100, 50, 95, 80, 55, 65}; 

        if (canBuyIceCream(budget, iceCreamPrices)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        scanner.close();
    }
}

