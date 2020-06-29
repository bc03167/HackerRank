import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BinaryPatterns {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final int maxPower = 20;
        int n = scanner.nextInt();
        String binaryN = "";
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i=maxPower;i >= 0; i-- ) {
            int factor = (int) (n / Math.pow(2,i));
            //System.out.println("n="+n
            // +" i="+i+
            // " 2^i="+Math.pow(2,i)+
            // " binaryN="+binaryN);

            if (factor > 0) {
                binaryN = "1"+binaryN;
                n -= Math.pow(2,i);
            } else {
                binaryN = "0"+binaryN;
            }
        }

        int maxConsec1s = 0;
        for (int i=0; i< binaryN.length(); i++) {
            int currentConsec1s = 0;
            if (binaryN.charAt(i) == '1')  {
                currentConsec1s++;
                int j=i+1;
                while (binaryN.charAt(j)=='1') {
                    currentConsec1s++;
                    j++;
                }
                if (currentConsec1s > maxConsec1s)
                    maxConsec1s = currentConsec1s;
                i = j;
            }
        }

        //System.out.println("n="+n+" binaryN="+binaryN);
        System.out.println(maxConsec1s);

        scanner.close();
    }
}
