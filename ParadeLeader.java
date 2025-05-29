import java.util.LinkedList;

public class ParadeLeader {
    public static void main(String[] args) {
        LinkedList<Integer> badgeNumbers = new LinkedList<>();
        badgeNumbers.add(1);
        badgeNumbers.add(2);
        badgeNumbers.add(3);
        badgeNumbers.add(4);
        badgeNumbers.add(5); 

        findLeader(badgeNumbers);
    }

    public static void findLeader(LinkedList<Integer> badgeNumbers) {
        int size = badgeNumbers.size();
        int startIndex;
        if (size % 2 == 0) {
            startIndex = (size / 2); 
        } else {
            startIndex = (size / 2); 
        }
        LinkedList<Integer> result = new LinkedList<>(badgeNumbers.subList(startIndex, size));
        System.out.println(result);
    }
}