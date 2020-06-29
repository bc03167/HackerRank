package com.ta.april;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Day23SherlockArrays {

    // Complete the balancedSums function below.
    static String balancedSums(List<Integer> arr) {

        if (arr.size() == 1)
            return("YES");
        else {

            int rSum = 0;
            int lSum = 0;
            for (int i = 0; i < arr.size(); i++)
                rSum += arr.get(i);
            for (int t = 0; t < arr.size(); t++) {

                lSum += (t == 0) ? 0 : arr.get(t-1);
                rSum -= arr.get(t);

                //System.out.printf("At t=%d lSum=%d rSum=%d\n",t,lSum,rSum);
                if (lSum == rSum)
                    return("YES");

            }

        }

        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(
                        System.getenv("OUTPUT_PATH")
                )
        );

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        for (int TItr = 0; TItr < T; TItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrItems = bufferedReader
                    .readLine()
                    .replaceAll("\\s+$", "")
                    .split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr.add(arrItem);
            }

            String result = balancedSums(arr);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

