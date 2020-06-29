package com.ta.june;

import java.util.Scanner;

public class SeparateNumber {

    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {
        for (int w = 1; w <= s.length()/2; w++) {
            String first = s.substring(0,w);
            boolean beautiful = Boolean.TRUE;
            for (int i = 0; i < s.length(); i+=w) {
                int startL = i;
                int startR = i + w;
                int endR = startR + w;
                if (endR > s.length()) {
                    endR  = s.length();
                }
                String _l = s.substring(startL, startR);
                String _r = s.substring(startR, endR);
                if (_l.equals("") || _r.equals(""))
                    break;
                long l = Long.parseLong(_l);
                long r = Long.parseLong(_r);
                if (r - l != 1) {
                    // forigive on 9,10 ; 99,100 ; 999,1000 symmetries
                    endR = (endR + 1) > s.length() ? endR : (endR+1) ;
                    long rr = Long.parseLong(s.substring(startR, endR));
                    if (rr - l != 1) {
                        beautiful = Boolean.FALSE;
                        break;
                    } else {
                        w++;
                        i = startL -1;
                    }
                }
            }
            if (beautiful) {
                System.out.println(first.charAt(0) != '0' ? "YES "+ first : "NO");
                return;
            }
        }
        System.out.println("NO");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}
