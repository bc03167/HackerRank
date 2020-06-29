import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HourGlassBoard {

    private static int hgPresentScore(int grid[][],int r, int c) {

        if (r-1 < 0 || r+1 >= 6 || c-1 < 0 || c+1 >= 6) {
            //System.out.println("Boundry disqualified. r="+r+" c="c);
            return (Integer.MIN_VALUE);
        }


        int score =
                    grid[r][c] +
                            grid[r+1][c-1] + //sw
                            grid[r+1][c] + //s
                            grid[r+1][c+1] +//se
                            grid[r-1][c-1] +//nw
                            grid[r-1][c] +//n
                            grid[r-1][c+1]; //ne
        return score;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        int maxHGScore = Integer.MIN_VALUE;
        for (int row = 0; row < 6; row++) {
            for (int col=0; col < 6; col++) {
                int thisRCScore =
                        HourGlassBoard.hgPresentScore(arr, row, col);

                if (thisRCScore> maxHGScore)
                    maxHGScore = thisRCScore;
            }
        }

        System.out.println(maxHGScore);
        scanner.close();
    }
}
