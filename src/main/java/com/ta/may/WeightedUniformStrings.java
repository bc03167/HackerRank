package com.ta.may;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WeightedUniformStrings {

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {

        Set<Integer> hs = new HashSet<>();
        String response[] = new String[queries.length];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int w = theValue(s.charAt(i));

            hs.add(w);
            int count = 1;
            for  (int j = i+1; j < s.length() && s.charAt(j) == c; j++, i++, count++) {
                w = theValue(s.charAt(j)) * (count+1);
                hs.add(w);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int weight = queries[i];

            if (hs.contains(weight))
                response[i] = "Yes";
            else
                response[i] = "No";


        }

        return (response);
    }

    private static Integer theValue(char c) {
        String latin = "abcdefghijklmnopqrstuvwxyz";
        return latin.indexOf(c)+1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH"))
        );

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);
            System.out.println(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

