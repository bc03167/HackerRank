package com.ta.may;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Pangrams {

    // Complete the pangrams function below.
    static String pangrams(String s) {

        String goal = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < goal.length(); i++) {
            char seek = goal.charAt(i);
            if (s.toLowerCase().indexOf(seek) < 0)
                return "not pangram";
        }

        return("pangram");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH"))
        );

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        System.out.println(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
