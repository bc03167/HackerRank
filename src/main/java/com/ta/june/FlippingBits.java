package com.ta.june;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FlippingBits {

    // Complete the flippingBits function below.
    static long flippingBits(long n) {
        String b32 = "";
        long decimal_b32 = 0;

        for (int x = 31; x >= 0; x--) {

            if ((n / Math.pow(2,x)) >= 1.0) {
                b32 += "0"; // should be 1 ...so make it 0
            } else {
                b32 += "1"; // should be 0 ... so make it 1
            }
            n = (long) (n % Math.pow(2, x));
        }
        //b32 flipped ... now reconsistitute it as Decimal

        for (int i = 31; i >= 0; i--) {
            long p = (long) (Long.parseLong(b32.charAt(i)+"")*Math.pow(2,31-i));
            decimal_b32 += p;
        }
        return decimal_b32;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = flippingBits(n);

            bufferedWriter.write(String.valueOf(result));
            System.out.println(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
