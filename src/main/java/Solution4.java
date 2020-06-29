import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution4 {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int totalJumps=0;

        for (int curCloud =0; curCloud < c.length-1;) {
            int bestJump = 0;
            try {
                bestJump = c[curCloud+2];
            } catch(Exception ignored) {
                ;
            }
            int worstJump = c[curCloud+1];
            if (bestJump != 1) {
                curCloud += 2;
            } else if (worstJump != 1) {
                curCloud +=1;
            } else {
                System.out.println("Cannot Jump Further!");
                break;
            }
            totalJumps++;
        }

        return totalJumps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
