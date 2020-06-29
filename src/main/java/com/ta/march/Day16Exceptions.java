package com.ta.march;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Day16Exceptions {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        try {
            System.out.println(Integer.parseInt(s));
        } catch (Exception e) {
            System.out.println("Bad String");
        }
    }
}