package com.ta.may;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Kaprekar {

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        int kCount = 0;
        int n = 0;
        for (n = p; n <= q; n++) {
            long nSquared = (long) Math.pow(n,2);
            String nSqString = nSquared+"";
            int midIndex = nSqString.length()/2;

            String l = nSqString.substring(0,(midIndex == 0) ? 1 : midIndex);
            String r = (midIndex == 0) ? "" : nSqString.substring(midIndex);
            int lNum = Integer.parseInt((l.equals("")) ? "0" : l);
            int rNum = Integer.parseInt((r.equals("")) ? "0" : r);
            if (lNum+rNum == n) {
                System.out.print(n + " ");
                kCount++;
            }
        }
        if (kCount == 0)
            System.out.println("INVALID RANGE");


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
