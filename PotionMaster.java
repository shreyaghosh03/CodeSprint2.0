import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class PotionMaster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double a = 1.0;
        double r = 1.0 / 3.0;
        double r_power_n = Math.pow(r, n);
        double sum = a * (1 - r_power_n) / (1 - r);
        BigDecimal bd = new BigDecimal(Double.toString(sum));
        bd = bd.setScale(5, RoundingMode.HALF_UP);
        System.out.println(bd.doubleValue());

        scanner.close();
    }
}