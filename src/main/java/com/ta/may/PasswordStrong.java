package com.ta.may;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PasswordStrong {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";
        final int minChars = 6;
        boolean hasNumber = Boolean.FALSE;
        boolean hasLC = Boolean.FALSE;
        boolean hasUC = Boolean.FALSE;
        boolean hasSC = Boolean.FALSE;
        int neededChars = 0;
        for (int i = 0; i < numbers.length(); i++) {
            if (password.indexOf(numbers.charAt(i)) >= 0) {
                hasNumber = Boolean.TRUE;
                break;
            }
        }
        if (!hasNumber)
            neededChars++;
        for (int i = 0; i < lower_case.length(); i++) {
            if (password.indexOf(lower_case.charAt(i)) >= 0) {
                hasLC = Boolean.TRUE;
                break;
            }
        }
        if (!hasLC)
            neededChars++;
        for (int i = 0; i < special_characters.length(); i++) {
            if (password.indexOf(special_characters.charAt(i)) >= 0) {
                hasSC = Boolean.TRUE;
                break;
            }
        }
        if (!hasSC)
            neededChars++;
        for (int i = 0; i < upper_case.length(); i++) {
            if (password.indexOf(upper_case.charAt(i)) >= 0) {
                hasUC = Boolean.TRUE;
                break;
            }
        }
        if (!hasUC)
            neededChars++;

        int gap = minChars - password.length() ;

        gap = Math.max(gap, 0);

        return Math.max(gap,neededChars);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH"))
        );

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        System.out.println(answer);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
