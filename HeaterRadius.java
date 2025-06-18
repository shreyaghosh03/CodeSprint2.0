import java.util.Arrays;
import java.util.Scanner;

public class HeaterRadius {
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = 0;

        for (int house : houses) {
            int closestDist = findClosestHeater(house, heaters);
            radius = Math.max(radius, closestDist);
        }

        return radius;
    }
    private static int findClosestHeater(int house, int[] heaters) {
        int low = 0, high = heaters.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (heaters[mid] == house) {
                return 0;
            } else if (heaters[mid] < house) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int dist1 = (low < heaters.length) ? Math.abs(heaters[low] - house) : Integer.MAX_VALUE;
        int dist2 = (high >= 0) ? Math.abs(heaters[high] - house) : Integer.MAX_VALUE;

        return Math.min(dist1, dist2);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] houses1 = new int[n];
        int[] heaters1 = {2};
        for (int i = 0; i<n; i++){
            houses1[i] = scanner.nextInt();
        }
        System.out.println(findRadius(houses1, heaters1)); 
    }
}