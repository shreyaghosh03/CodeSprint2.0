import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SuperPrimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        boolean[] isPrime = new boolean[n + 1];
        if (n >= 0) { 
            for (int i = 0; i <= n; i++) {
                isPrime[i] = true;
            }
        }
        if (n >= 0) isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        List<Integer> primesList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primesList.add(i);
            }
        }
        int maxPrimeIndex = primesList.size();
        boolean[] isIndexPrime = new boolean[maxPrimeIndex + 1];
        if (maxPrimeIndex >= 0) {
            for (int i = 0; i <= maxPrimeIndex; i++) {
                isIndexPrime[i] = true;
            }
        }
        if (maxPrimeIndex >= 0) isIndexPrime[0] = false;
        if (maxPrimeIndex >= 1) isIndexPrime[1] = false;

        for (int p = 2; p * p <= maxPrimeIndex; p++) {
            if (isIndexPrime[p]) {
                for (int i = p * p; i <= maxPrimeIndex; i += p) {
                    isIndexPrime[i] = false;
                }
            }
        }
        List<Integer> superPrimes = new ArrayList<>();
        for (int i = 0; i < primesList.size(); i++) {
            int position = i + 1;
            if (isIndexPrime[position]) {
                superPrimes.add(primesList.get(i));
            }
        }
        for (int i = 0; i < superPrimes.size(); i++) {
            System.out.print(superPrimes.get(i));
            if (i < superPrimes.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println(); 
    }
}