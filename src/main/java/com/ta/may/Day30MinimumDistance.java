package com.ta.may;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Day30MinimumDistance {

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        int md = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++)
            for (int j = i+1; j < a.length; j++) {
//                if (i == j)
//                    continue;
                if (a[i] == a[j] ) {
                    int d = Math.abs(j - i);
                    if (d < md)
                        md = d;
                }
            }

        if (md == Integer.MAX_VALUE)
            return -1;

;        return md;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH"))
        );

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

