import java.util.Scanner;

public class ParcelPacking {
    public static boolean isValid(long maxWeight, int K, int[] parcels) {
        long currentSum = 0;
        int boxesUsed = 1;
        for (int parcelWeight : parcels) {
            if (parcelWeight > maxWeight) {
                return false;
            }
            if (currentSum + parcelWeight <= maxWeight) {
                currentSum += parcelWeight;
            } else {
                boxesUsed++;
                currentSum = parcelWeight;
                if (boxesUsed > K) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] parcels = new int[N];
        long sumOfWeights = 0;
        int maxIndividualWeight = 0;
        for (int i = 0; i < N; i++) {
            parcels[i] = scanner.nextInt();
            sumOfWeights += parcels[i];
            if (parcels[i] > maxIndividualWeight) {
                maxIndividualWeight = parcels[i];
            }
        }
        long low = maxIndividualWeight;
        long high = sumOfWeights;
        long ans = sumOfWeights; 
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isValid(mid, K, parcels)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(ans);
        scanner.close();
    }
}