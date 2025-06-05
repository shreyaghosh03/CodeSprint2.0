import java.util.Arrays;

public class CardTrickSimple {

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        return deck;
    }

    public static void main(String[] args) {
        CardTrickSimple solver = new CardTrickSimple();

        int[] deck1 = {5, 12, 9};
        int[] result1 = solver.deckRevealedIncreasing(deck1);
        System.out.println("Example 1 Input: " + Arrays.toString(new int[]{5, 12, 9}) + ", Output: " + Arrays.toString(result1)); 

        int[] deck2 = {1, 10, 3, 8, 6};
        int[] result2 = solver.deckRevealedIncreasing(deck2);
        System.out.println("Example 2 Input: " + Arrays.toString(new int[]{1, 10, 3, 8, 6}) + ", Output: " + Arrays.toString(result2)); 
    }
}