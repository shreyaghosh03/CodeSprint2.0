import java.util.Scanner;

public class SpellheavenDuel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] merlinSpells = new int[n];
        for (int i = 0; i < n; i++) {
            merlinSpells[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] morganaSpells = new int[m];
        for (int i = 0; i < m; i++) {
            morganaSpells[i] = scanner.nextInt();
        }
        scanner.close();
        int morganaMaxPower = 0;
        if (m > 0) { 
            for (int power : morganaSpells) {
                if (power > morganaMaxPower) {
                    morganaMaxPower = power;
                }
            }
        }
        int merlinRequiredMinPower = morganaMaxPower + 1;
        long totalMana = 0; 
        for (int merlinSpellPower : merlinSpells) {
            if (merlinSpellPower < merlinRequiredMinPower) {
                totalMana += (merlinRequiredMinPower - merlinSpellPower);
            }
        }
        System.out.println(totalMana);
    }
}
