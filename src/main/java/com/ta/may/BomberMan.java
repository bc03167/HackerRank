package com.ta.may;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class GridPoint {
    int row;
    int col;

    GridPoint(int r, int c) {
        this.row = r;
        this.col = c;
    }
}

public class BomberMan {

    // Complete the bomberMan function below.
    static String[] bomberMan(int n, String[] grid) {
        long t = 1;
        long width = grid[0].length();
        long height = grid.length;
        do {
            if (n == t) return grid;
            List<GridPoint> bombPlots = new LinkedList<>();
            for (int r = 0; r < height; r++) {
                for (int c = 0; c < width; c++)
                    if (grid[r].charAt(c) == 'O')
                        bombPlots.add(new GridPoint(r, c));
            }
            t++;
            for (int r = 0; r < height; r++) {
                grid[r] = "";
                for (int c = 0; c < width; c++)
                    grid[r] += "O";
            }
            if (n == t ) return grid;
            t++;
            for (int b = 0; b < bombPlots.size(); b++) {
                GridPoint bomb = bombPlots.get(b);



                grid[bomb.row] =
                        grid[bomb.row].substring(0, bomb.col)
                                + "."
                                + grid[bomb.row].substring(bomb.col + 1);
                if (bomb.row - 1 >= 0)
                    grid[bomb.row - 1] =
                            grid[bomb.row - 1].substring(0, bomb.col)
                                    + "."
                                    + grid[bomb.row - 1].substring(bomb.col + 1);
                if (bomb.row + 1 < height)
                    grid[bomb.row + 1] =
                            grid[bomb.row + 1].substring(0, bomb.col)
                                    + "."
                                    + grid[bomb.row + 1].substring(bomb.col + 1);
                if (bomb.col - 1 >= 0)
                    grid[bomb.row] =
                            grid[bomb.row].substring(0, bomb.col - 1)
                                    + "."
                                    + grid[bomb.row].substring(bomb.col);
                if (bomb.col + 1 < width)
                    grid[bomb.row] =
                            grid[bomb.row].substring(0, bomb.col + 1)
                                    + "."
                                    + grid[bomb.row].substring(
                                    (bomb.col + 2) < width ?
                                            (bomb.col + 2) :
                                            (bomb.col + 1 < width ?
                                                    bomb.col+1 :
                                                    bomb.col));
                if (grid[bomb.row].length() > width)
                    grid[bomb.row] = grid[bomb.row].substring(0,(int)width);
            }
            System.out.println("t="+t);
        } while (t < n);

        return grid;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH"))
        );

        String[] rcn = scanner.nextLine().split(" ");

        int r = Integer.parseInt(rcn[0]);

        int c = Integer.parseInt(rcn[1]);

        int n = Integer.parseInt(rcn[2]);

        String[] grid = new String[r];

        for (int i = 0; i < r; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = bomberMan(n, grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);
            System.out.println(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
                System.out.println();
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
