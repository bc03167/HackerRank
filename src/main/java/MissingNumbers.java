import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MissingNumbers {

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] arr, int[] brr) {
        Map<Integer,Integer> bMap = new HashMap<>();
        int missingArr[] = new int[brr.length];

        //make a Map for original number custody
        for (int i = 0; i < brr.length; i++) {
            if (bMap.get(brr[i]) == null)
                bMap.put(brr[i], 1);
            else
                bMap.put(brr[i], bMap.get(brr[i]) + 1);
        }

        //now, check cardinality of bMap entry vs cardinality of arr entry
        int missingIndex = 0;
        for (Map.Entry<Integer,Integer> bEntry : bMap.entrySet()) {
            int target = bEntry.getKey();
            int bCount = bEntry.getValue();
            int aCount = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target)
                    aCount++;
            }
            if (aCount < bCount)
                missingArr[missingIndex++] = target;
        }

        Arrays.sort(missingArr);

        return missingArr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        int[] result = missingNumbers(arr, brr);



        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0)
                continue;
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
