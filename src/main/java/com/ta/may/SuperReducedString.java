package com.ta.may;


import java.io.*;


public class SuperReducedString {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {

        int i = -1;
        while ((i = adjacentCharsAppear(s)) >= 0) {
            String beforePair = s.substring(0,i);
            String afterPair = s.substring(i+2);
            s = beforePair + afterPair;
        }

        return (s.length() > 0 ? s : "Empty String");

    }

    private static int adjacentCharsAppear(String s) {

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                return (i - 1);
        }
        return (-1);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH"))
        );

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        System.out.println(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}


