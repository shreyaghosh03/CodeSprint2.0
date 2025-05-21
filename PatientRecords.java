import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PatientRecords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        scanner.nextLine(); 
        
        Map<String, Boolean> uniquePatients = new LinkedHashMap<>();
        
        for (int i = 0; i < n; i++) {
            String patientName = scanner.nextLine().trim();
            
            if (isStartsWithVowel(patientName) && !uniquePatients.containsKey(patientName)) {
                uniquePatients.put(patientName, true);
            }
        }
        
        System.out.println(uniquePatients.size());
        
        for (String name : uniquePatients.keySet()) {
            System.out.println(name);
        }
        
        scanner.close();
    }

    private static boolean isStartsWithVowel(String name) {
        char firstChar = name.toLowerCase().charAt(0);
        return firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u';
    }
}