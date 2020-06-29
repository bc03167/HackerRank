package com.ta.may;

import java.util.Scanner;

// Credit for algorithm:
// https://stackoverflow.com/questions/16605991/number-of-subarrays-divisible-by-k


public class ConsecutiveSequences {

    private static void processATrial(long[] a, int k) {
        long B[] = new long[k];
        B[0]++;
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            s = (int) ((s + a[i]) % k);
            B[s]++;
        }
        long ans = 0;
        for (int i = 0; i < k; i++)
            ans = ans + B[i] * (B[i] - 1) / 2;
        System.out.println(ans);
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        long a[] = null;
        int loop = s.nextInt();
        for (int t = 0; t < loop; t++) {
            int aSize = s.nextInt();
            int div = s.nextInt();
            a = new long[aSize];
            for (int j = 0; j < aSize; j++)
                a[j] = s.nextInt();
            //System.out.println("Trial=" + t + " size=" + aSize + " div=" + div);
            processATrial(a, div);
        }

    }


}
