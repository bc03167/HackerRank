package com.ta.may;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ManasaStonesRecursive {

    static List<Integer> l = new LinkedList<>();
    static Set<Integer> s = new HashSet<>();

    static int[] stones(int n, int a, int b) {
        Set<Integer> set = new TreeSet<>();
        set.add(0);
        for (int j = 1; j < n; j++) {
            Set<Integer> newSet = new TreeSet<Integer>();
            for (int el : set) {
                newSet.add(el + a);
                newSet.add(el + b);
            }
            set = newSet;
        }
        int[] r = set.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .toArray();
        Arrays.sort(r);
        return(r);
    }

    // Complete the stones function below.
    static int[] stonesR(int n, int a, int b) {
        int r[] = new int[n];
        int depth = l.size() -1;
        if (l.size() < n) {
            int stoneTagA = l.get(depth)+a;
            l.add(stoneTagA);
            r = stonesR(n, a, b);
            if (l.size() == n) {
                s.add(l.get(n - 1));
            }
            l.remove(depth+1);
        }

        depth = l.size() - 1;
        if (l.size() < n) {
            int stoneTagB = l.get(depth)+b;
            l.add(stoneTagB);
            r = stonesR(n, a, b);
            if (l.size() == n) {
                s.add(l.get(n - 1));
            }
            l.remove(depth+1);
        }

        r = s.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .toArray();
        Arrays.sort(r);
        return r;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH"))
        );

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int a = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int b = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            l = new LinkedList<>();
            s = new HashSet<>();
            l.add(0);
            int[] result = stones(n, a, b);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
