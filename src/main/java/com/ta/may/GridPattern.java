package com.ta.may;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class GridPattern {

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {

        int maxGcol = G[0].length() - P[0].length();
        int maxPcol = P[0].length() - 1;
        int maxProw = P.length;
        int maxGrow = G.length - P.length;

        String ret = "NO";
        for (int gRow = 0; gRow <= maxGrow; gRow++)
            for (int gCol = 0; gCol <= maxGcol; gCol++) {
                String candidate = G[gRow].substring(gCol, gCol + P[0].length());
                if (candidate.equals(P[0])) {
                    //basis satisfied
                    for (int r = 0; r < maxProw; r++) {
                        String candy = G[gRow + r].substring(gCol, gCol + P[0].length());
                        if (candy.equals(P[r])) {
                            ret = "YES";
                        } else {
                            ret = "NO";
                            break;
                        }
                    }
                    if (ret.equals("YES"))
                        return "YES";
                }
            }


        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH"))
        );

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            System.out.println(result);
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
