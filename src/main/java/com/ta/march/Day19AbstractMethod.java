package com.ta.march;

import java.io.*;
import java.util.*;

interface AdvancedArithmetic{
    int divisorSum(int n);
}
class AnotherCalculator implements AdvancedArithmetic {

    //return the sum of all divisors of n
    public int divisorSum(int n) {

        int theSum = 0;

        for (int i=1; i <= n; i++) {
            if (n % i == 0)
                theSum += i;
        }
        return theSum;
    }
}

class AbstractMethod {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        AdvancedArithmetic myCalculator = new AnotherCalculator();
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}