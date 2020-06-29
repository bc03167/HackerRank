package com.ta.june;

import java.util.Scanner;

public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        long plusCount = 0;
        long minusCount = 0;
        long zeroCount = 0;

        for (int i : arr) {
            if (i < 0)
                minusCount++;
            else if (i > 0)
                plusCount++;
            else
                zeroCount++;
        }

        System.out.printf(" %6.6f\n %6.6f\n %6.6f \n",
                (double) plusCount/arr.length,
                (double) minusCount/arr.length,
                (double) zeroCount/arr.length
        );
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

        plusMinus(arr);

        scanner.close();
    }
}

