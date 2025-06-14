import java.util.HashSet;
import java.util.Objects; 
import java.util.Scanner;

public class BennyThePig {
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public static int countSlips(String S) {
        HashSet<Point> visited = new HashSet<>();
        int currentX = 0;
        int currentY = 0;
        visited.add(new Point(currentX, currentY));
        int slips = 0;
        for (char move : S.toCharArray()) {
            switch (move) {
                case 'L':
                    currentX--;
                    break;
                case 'R':
                    currentX++;
                    break;
                case 'U':
                    currentY++;
                    break;
                case 'D':
                    currentY--;
                    break;
            }
            Point newPosition = new Point(currentX, currentY);
            if (visited.contains(newPosition)) {
                slips++;
            } else {
                visited.add(newPosition);
            }
        }
        return slips;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Input: " + input+ ", Slips: " + countSlips(input)); 
    }
}
