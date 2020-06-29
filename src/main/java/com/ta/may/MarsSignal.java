package com.ta.may;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MarsSignal {

    // Complete the marsExploration function below.
    static int marsExploration(String s) {

        long sigStrength = s.length();
        long gap = 0;

        for (int i = 0; i < sigStrength; i += 3) {
            if (s.charAt(i) != 'S')
                gap++;
            if (s.charAt(i + 1) != 'O')
                gap++;
            if (s.charAt(i + 2) != 'S')
                gap++;
        }
        return ((int) gap);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH"))
        );

        String s = scanner.nextLine();

        int result = marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        System.out.println(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
