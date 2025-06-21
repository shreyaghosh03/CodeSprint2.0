import java.util.Scanner; 

public class NumberToWords {
    private static final String[] units = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private static final String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return convert(num);
    }
    private String convert(int num) {
        if (num < 20) {
            return units[num];
        }
        if (num < 100) {
            return (tens[num / 10] + " " + units[num % 10]).trim();
        }
        if (num < 1000) {
            return (units[num / 100] + " Hundred " + convert(num % 100)).trim();
        }
        if (num < 1000000) {
            return (convert(num / 1000) + " Thousand " + convert(num % 1000)).trim();
        }
        if (num < 1000000000) {
            return (convert(num / 1000000) + " Million " + convert(num % 1000000)).trim();
        }
        return (convert(num / 1000000000) + " Billion " + convert(num % 1000000000)).trim();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        NumberToWords converter = new NumberToWords();
        System.out.print("Enter a non-negative integer (up to 2^31 - 1): ");
    
        try {
            int userNumber = scanner.nextInt(); 
            if (userNumber < 0) {
                System.out.println("Error: Please enter a non-negative integer.");
            } else {
                String words = converter.numberToWords(userNumber);
                System.out.println("The number in words is: " + words);
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a valid integer.");
        } finally {
            scanner.close(); 
        }
    }
}