package com.ta.may;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CavityCartography {

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {

        //grid is NxN (square)
        int minRow = 1;
        int maxRow = grid.length - 2;
        int minCol = 1;
        int maxCol = grid.length - 2;
        String result[] = new String[grid.length];

        for (int row = 0; row < grid.length; row++)
            result[row] = grid[row]+"";

        for (int row = minRow; row <= maxRow; row++)
            for (int col = minCol; col <= maxCol; col++) {
                int t = Integer.parseInt("" + grid[row].charAt(col));
                if (
                        t > Integer.parseInt("" + grid[row-1].charAt(col)) &&
                        t > Integer.parseInt("" + grid[row].charAt(col-1)) &&
                        t > Integer.parseInt("" + grid[row+1].charAt(col)) &&
                        t > Integer.parseInt("" + grid[row].charAt(col+1))
                ) {
                    result[row] = result[row].substring(0,col) +
                            "X" +
                            result[row].substring(col+1);
                }
            }


        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH"))
        );

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);
            System.out.println(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

