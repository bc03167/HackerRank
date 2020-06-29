package com.ta.may;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class EvenBreadLoaves {
    static boolean allEven = Boolean.TRUE;

    // Complete the fairRations function below.
    static int fairRations(int[] B) {

        int loafCount = 0;
        int lastIndex = B.length - 1;
        for (int i = lastIndex; i >= 0; i--) {
            int incIndex = i + 1;
            int decIndex = i - 1;

            allEven = Boolean.TRUE;
            for (int j = 0; j < lastIndex; j++)
                if (B[j] % 2 == 1) {
                    allEven = Boolean.FALSE;
                    break;
                }

            if (allEven)
                break;

            if (B[i] % 2 == 0)
                continue;
            else {
                B[i]++;
                loafCount++;
                if (incIndex <= lastIndex)
                    if (B[incIndex] % 2 == 1) {
                        B[incIndex]++;
                        loafCount++;
                        i = B.length;
                        continue;
                    }
                if (decIndex >= 0) {
                        B[decIndex]++;
                        loafCount++;
                        i = B.length;
                        continue;
                    }
            }
        }
        return allEven ? loafCount : -loafCount;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = fairRations(B);
        System.out.println(result >= 0 ? result : "NO");

        bufferedWriter.write(result >= 0 ? String.valueOf(result)  : "NO");
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
