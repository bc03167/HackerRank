package com.ta.may;

import java.io.*;
import java.util.*;

public class ConsecutiveDivisables {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int a[] = null;
        int loop = s.nextInt();
        for (int t = 0; t < loop; t++) {
            int aSize = s.nextInt();
            int div = s.nextInt();
            a = new int[aSize];
            for (int j = 0; j < aSize; j++)
                a[j] = s.nextInt();
            //System.out.println("Trial="+t+" size="+aSize+" div="+div);
            processTrial(a, div);
        }
    }

    private static void processTrial(int a[], int div) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum % div == 0) {
                    //ConsecutiveDivisables.deliverSequence(a, i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void deliverSequence(int[] a, int i, int j) {

        for (int x = i; x <= j; x++)
            System.out.print(a[x]+" ");
       System.out.println();
    }


}