package com.ta.june;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Funny {

    // Complete the funnyString function below.
    static String funnyString(String s) {

        String r = "";
        for (int i = s.length() -1; i >=0 ; i--)
            r += s.charAt(i)+"";
        for (int i = 1; i < s.length(); i++) {
            int deltaS = s.charAt(i) - s.charAt(i-1);
            int deltaR = r.charAt(i) - r.charAt(i-1);
            if (Math.abs(deltaS) != Math.abs(deltaR))
                return "Not Funny";
        }

        return "Funny";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

