package com.ta.may;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Day29BeautifulTriplet {

    // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {

        List<List<Integer>> bT = new LinkedList<>();
        int bTCount = 0;

        for (int k = arr.length-1; k >= 0; k--) {

            List<Integer> l = new LinkedList<>();
            l.add(k);

            for (int j=k-1; j >= 0; j--) {

                if(arr[k] - arr[j] == d) {
                    l.add(j);
                    for (int i = j-1; i>= 0; i--)

                        if (arr[j] - arr[i] == d) {
                            l.add(i);
                            bT.add(l);
                            Collections.sort(l);
                            for (int z : l)
                                System.out.print(z+" ");
                            System.out.println();
                            //l = new LinkedList<>();
                            l.remove(l.size()-1);
                            bTCount++;
                        }

                }
            }
        }

        return bTCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(
                        System.getenv("OUTPUT_PATH")
                )
        );

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
