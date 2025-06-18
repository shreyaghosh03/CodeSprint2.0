import java.util.Arrays;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String housesLine = scanner.nextLine();
        housesLine = housesLine.substring(housesLine.indexOf('['));
        int[] houses = parseArrayString(housesLine);
        String heatersLine = scanner.nextLine();
        heatersLine = heatersLine.substring(heatersLine.indexOf('['));
        int[] heaters = parseArrayString(heatersLine);

        scanner.close();
        Arrays.sort(houses);
        Arrays.sort(heaters);

        Solution sol = new Solution(); 
        int result = sol.findRadius(houses, heaters);
        System.out.println(result);
    }
    private static int[] parseArrayString(String input) {
        String cleaned = input.substring(1, input.length() - 1).trim();
        if (cleaned.isEmpty()) {
            return new int[0];
        }
        return Arrays.stream(cleaned.split(",\\s*"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    public int findRadius(int[] houses, int[] heaters) {
        int low = 0;
        int high = 1_000_000_000;
        int result = high; 
        while (low <= high) {
            int mid = low + (high - low) / 2; 
            if (canWarmAllHouses(mid, houses, heaters)) {
                result = mid;       
                high = mid - 1;
            } else {
                low = mid + 1;     
            }
        }
        return result;
    }
    private boolean canWarmAllHouses(int radius, int[] houses, int[] heaters) {
        int heaterIdx = 0; 
        if (houses.length == 0) return true;
        if (heaters.length == 0) return false;
        for (int house : houses) {
            while (heaterIdx < heaters.length - 1 && (heaters[heaterIdx] + radius < house)) {
                heaterIdx++;
            }
            if (Math.abs(house - heaters[heaterIdx]) > radius) {
                return false; 
            }
        }
        return true; 
    }
}