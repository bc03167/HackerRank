package com.ta.may;


import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Day26HackosLibraryFine {

}

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int domReturned = scanner.nextInt();
        int moyReturned = scanner.nextInt();
        int yrReturned = scanner.nextInt();
        int domExpected = scanner.nextInt();
        int moyExpected = scanner.nextInt();
        int yrExpected = scanner.nextInt();

        LocalDate retDt = LocalDate.of(yrReturned, moyReturned, domReturned);
        LocalDate expDt = LocalDate.of(yrExpected, moyExpected, domExpected);

        if (retDt.getYear() > expDt.getYear())
            System.out.println(10_000);
        else if (expDt.getYear() > retDt.getYear())
            System.out.println(0);
        else if (retDt.getMonth().getValue() > expDt.getMonth().getValue())
            System.out.println((retDt.getMonth().getValue() - expDt.getMonth().getValue()) * 500);
        else if (retDt.getDayOfMonth() > expDt.getDayOfMonth())
            System.out.println((retDt.getDayOfMonth() - expDt.getDayOfMonth()) * 15);
        else
            System.out.println(0);
    }

}
