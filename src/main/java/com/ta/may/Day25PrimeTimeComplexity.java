package com.ta.may;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Day25PrimeTimeComplexity {

    private static final Scanner scanner = new Scanner(System.in);
    private static boolean isPrime=Boolean.TRUE;

    public static void main(String[] args) {

        int trials = scanner.nextInt();
        for (int i = 0; i < trials; i++) {
            isPrime = Boolean.TRUE;
            int n = scanner.nextInt();
            for (int factor=2; factor < Math.pow(n,0.5)+1; factor++) {
                if (n % factor == 0) {
                    isPrime=Boolean.FALSE;
                    break;
                }
            }
            if (n < 2)
                isPrime = Boolean.FALSE;
            else if (n==2)
                isPrime = Boolean.TRUE;

            System.out.println(isPrime == Boolean.TRUE ? "Prime" : "Not prime");
        }

    }
}





