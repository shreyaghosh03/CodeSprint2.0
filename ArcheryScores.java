import java.util.Scanner;

public class ArcheryScores{
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int countGoodShots = 0, countMissedShots =0;
for(int i=0; i<n; i++){
int score = scanner.nextInt();
if(score>7){
countGoodShots++;
}
else{
countMissedShots++;
}
}
    System.out.println( countGoodShots + " " + countMissedShots);
    scanner.close();
}
}
