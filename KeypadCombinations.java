import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class KeypadCombinations {

    private static final HashMap<Character, String> digitToLettersMap = new HashMap<>();
    
    static {
        digitToLettersMap.put('2', "abc");
        digitToLettersMap.put('3', "def");
        digitToLettersMap.put('4', "ghi");
        digitToLettersMap.put('5', "jkl");
        digitToLettersMap.put('6', "mno");
        digitToLettersMap.put('7', "pqrs");
        digitToLettersMap.put('8', "tuv");
        digitToLettersMap.put('9', "wxyz");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the digits: ");
        String digits = scanner.nextLine();

        List<String> combinations = generateCombinations(digits);
        
        System.out.println("Possible combinations: " + combinations);
        scanner.close();
    }

    private static List<String> generateCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        backtrack("", digits, 0, result);
        return result;
    }

    private static void backtrack(String combination, String digits, int index, List<String> result) {
        if (index == digits.length()) {
            result.add(combination);
            return;
        }

        char digit = digits.charAt(index);
        String letters = digitToLettersMap.get(digit);
        
        if (letters != null) {
            for (char letter : letters.toCharArray()) {
                backtrack(combination + letter, digits, index + 1, result);
            }
        }
    }
}