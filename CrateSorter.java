import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CrateSorter {
    static class CrateInfo {
        int number;
        int frequency;

        public CrateInfo(int number, int frequency) {
            this.number = number;
            this.frequency = frequency;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int crateLabel = scanner.nextInt();
            frequencyMap.put(crateLabel, frequencyMap.getOrDefault(crateLabel, 0) + 1);
        }
        scanner.close();

        List<CrateInfo> crateList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            crateList.add(new CrateInfo(entry.getKey(), entry.getValue()));
        }
        Collections.sort(crateList, new Comparator<CrateInfo>() {
            @Override
            public int compare(CrateInfo o1, CrateInfo o2) {
                if (o1.frequency != o2.frequency) {
                    return o2.frequency - o1.frequency; 
                } else {
                    return o1.number - o2.number; 
                }
            }
        });
        StringBuilder result = new StringBuilder();
        for (CrateInfo crate : crateList) {
            for (int i = 0; i < crate.frequency; i++) {
                result.append(crate.number).append(" ");
            }
        }
        System.out.println(result.toString().trim()); 
    }
}