package com.ta.may;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AlmostSorted {

    // Complete the almostSorted function below.
    static void almostSorted(int[] arr) {

        if (isSorted(arr))
            System.out.println("YES");

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length; j++)
                if (j == i)
                    continue;
                else {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    if (isSorted((arr))) {
                        System.out.println("yes");
                        System.out.println("swap " + (i+1) + " " + (j+1));
                        return;
                    }
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }


        BlockingQueue<Integer> bq = new LinkedBlockingQueue<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j == i)
                    continue;

                try {
                    reverse(arr, i, j, bq);
                    if (isSorted(arr)) {
                        System.out.println("yes\n" + "reverse " + (i + 1) + " " + (j + 1));
                        return;
                    }
                    reverse(arr, i, j, bq);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        System.out.println("no");
    }

    private static void reverse(int a[], int i, int j, BlockingQueue bq) throws Exception {

        for (int k = i; k <= j; k++)
            bq.add(a[k]);

        for (int k = j; k >= i; k--)
            a[k] = ((Integer) bq.take()).intValue();

    }

    private static boolean isSorted(int[] a) {

        for (int i = 0; i < a.length; i++)
            if (a[i + 1 < a.length ? i + 1 : i] < a[i])
                return Boolean.FALSE;

        return Boolean.TRUE;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        almostSorted(arr);

        scanner.close();
    }
}

