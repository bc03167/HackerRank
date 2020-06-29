package com.ta.may;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StrangeCounter {

    // Complete the strangeCounter function below.
    static long strangeCounter(long t) {

        //Long[] plot = new Long[3];

        long strat = 3;
        int totalSteps = 0;

        for (int pass = 1; pass <= t; pass++) {

            long priorPassCapacity = strat;
            if ( pass > 1)
                priorPassCapacity = 2 * strat;
            strat = priorPassCapacity;
            //System.out.println("On pass =" + pass + " built plot[].length=" + plot.length);

            //int theIndex = 0;
            long stratI = 0;
            for (int i = 0; i < priorPassCapacity && totalSteps != t; i++) {
                stratI = priorPassCapacity - i;
                totalSteps++;
                //System.out.println("plot[" + i + "] = [" + totalSteps + "," + plot[i] + "]");
                //theIndex = i;
            }
            if (totalSteps == t)
                return stratI;
        }


        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
