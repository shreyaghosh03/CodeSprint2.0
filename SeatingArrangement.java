import java.util.Scanner;

public class SeatingArrangement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        char[][] hall = new char[n][n];
        int count =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    hall[i][j] = '1'; 
                    count++;
                } else {
                    hall[i][j] = '0'; 
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(hall[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Total students seated : " + " " + count);

        scanner.close();
    }
}