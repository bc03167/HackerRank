package com.ta.april;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Day22Pairs {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        int totalCount = 0;

        Arrays.sort(arr);
        for (int i = 0; i < arr.length;  i++)
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] - arr[j] == k || arr[j] - arr[i] == k) {
                    totalCount++;
                    break;
                }
            }

        return(totalCount);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(
                        System.getenv("OUTPUT_PATH")
                )
        );

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);
        //System.out.println("result="+result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
