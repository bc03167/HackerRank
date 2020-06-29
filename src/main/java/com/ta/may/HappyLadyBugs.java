package com.ta.may;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HappyLadyBugs {

    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {

        char bugVine[] = b.toCharArray();
        boolean theBugHappy = Boolean.FALSE;

        if (b.indexOf("_") >= 0)
            Arrays.sort(bugVine);

        if (bugVine[0] == '_' && bugVine[bugVine.length - 1] == '_')
            return "YES";

        if (bugVine.length <= 1)
            return "NO";


        for (int i = 0; i < bugVine.length; i++) {
            char theBug = bugVine[i];
            if (theBug == '_') {
                continue;
            }
            theBugHappy = Boolean.FALSE;

            if (i > 0) {
                if (bugVine[i - 1] == theBug)
                    theBugHappy = Boolean.TRUE;
            } else {
                if (bugVine[i + 1] == theBug)
                    theBugHappy = Boolean.TRUE;
            }
            if (i + 1 < bugVine.length) {
                if (bugVine[i + 1] == theBug)
                    theBugHappy = Boolean.TRUE;
            } else {
                if (bugVine[i - 1] == theBug)
                    theBugHappy = Boolean.TRUE;
            }
            if (!theBugHappy)
                return "NO";
        }


        return theBugHappy ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            System.out.println(result);
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

