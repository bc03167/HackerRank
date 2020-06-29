package com.ta.march;

import java.util.*;
import java.io.*;

//Write your code here

class ACalculator  {

    public int power(int n, int p) throws Exception{
        if (p < 0 || n < 0) { Exception e = new Exception("n and p should be non-negative");
            throw e;
        } else {
            return (int) Math.pow((double)n, (double)p);
        }

    }
}

public class Day17ThrowsException{

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {

            int n = in.nextInt();
            int p = in.nextInt();
            ACalculator myCalculator = new ACalculator();
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        in.close();
    }
}
