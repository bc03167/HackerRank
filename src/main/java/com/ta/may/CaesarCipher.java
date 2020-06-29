package com.ta.may;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CaesarCipher {

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {

        char latin[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char cipher[] = new char[latin.length];
        char payload[] = new char[s.length()];

        int sz = latin.length;
        for (int i = 0; i < sz; i++) {
            cipher[(sz - (k%sz) + i) % sz] = latin[i];
        }

        sz = s.length();
        for (int i = 0; i < sz; i++) {
            char theLetterPlain = s.charAt(i);
            boolean isUpper = Boolean.FALSE;
            if (theLetterPlain >= 'A' && theLetterPlain <= 'Z') {
                isUpper = Boolean.TRUE;
            }
            String l = String.valueOf(latin);
            int index = l.indexOf(isUpper ? Character.toLowerCase(theLetterPlain) : theLetterPlain);
            char theLetterCaesar = (index >= 0) ? cipher[index] : theLetterPlain;
            payload[i] = isUpper ? Character.toUpperCase(theLetterCaesar): theLetterCaesar;
        }

        return String.valueOf(payload);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH"))
        );

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        System.out.println(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
