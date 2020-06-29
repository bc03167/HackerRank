package com.ta.may;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TwoCharacters {

    // Complete the alternate function below.
    static int alternate(String s) {
        //Set<String> ss = new HashSet<>();
        int maxSize = 0;
        String maxString="";
        for (int i = 0; i < s.length(); i++) {
            //ss.add(s.substring(i,1));
            for (int j = i + 1; i < s.length() && j < s.length(); j++) {

                String keep1 = s.charAt(i) + "";
                String keep2 = s.charAt(j) + "";
                if (keep1.equals(keep2))
                    continue;
                String c = TwoCharacters.auditionKeepingPair(s, keep1, keep2);
                if (TwoCharacters.tickTock(c) == Boolean.TRUE) {
                    int curSize = c.length();
                    if (curSize > maxSize) {
                        maxSize = curSize;
                        maxString = c;
                        System.out.println("maxString=[" + maxString + "]");
                    }
                }
            }
        }
        System.out.println("maxString=[" + maxString + "]");
        return maxSize;
    }

    private static boolean tickTock(String candidate) {

        char tick = candidate.charAt(0);
        char tock = candidate.charAt(1);

        for (int i = 1; i < candidate.length(); i += 2)
            if (candidate.charAt(i - 1) != tick || candidate.charAt(i) != tock)
                return Boolean.FALSE;

        return Boolean.TRUE;
    }

    private static String auditionKeepingPair(String s, String keep1, String keep2) {
        String candidate = "";
        //System.out.println("Auditioning keeping (" + keep1 + "," + keep2 + ")");
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == keep1.charAt(0) || s.charAt(i) == keep2.charAt(0))
                candidate += s.charAt(i) + "";

        //System.out.println("candidte=" + candidate);
        return candidate;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH"))
        );

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        System.out.println(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
