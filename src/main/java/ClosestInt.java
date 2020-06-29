import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ClosestInt {

    // Complete the closestNumbers function below.
    static Integer[] closestNumbers(int[] arr) {
        List<Integer> retL = new ArrayList<>();

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (i == j)
                    continue;
                int thisDiff = Math.abs(arr[i] - arr[j]);
                if (thisDiff > minDiff)
                    continue;
                else if (thisDiff < minDiff) {
                    minDiff = thisDiff;
                    retL = new ArrayList<>();
               //     retL.add(Math.min(arr[i],arr[j]));
               //     retL.add(Math.max(arr[i],arr[j]));
                } //else if (thisDiff == minDiff) {
                    retL.add(Math.min(arr[i],arr[j]));
                    retL.add(Math.max(arr[i],arr[j]));
                    for (int k=0; k < retL.size(); k++) {
                        System.out.print(retL.get(k)+" ");
                    }
                    System.out.println();
               // }
            }
        }

        Integer retA[] = new Integer[retL.size()];
        Collections.sort(retL);
        retL.toArray(retA);
        return retA;
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

        Integer[] result = closestNumbers(arr);

        for (int i = 0; i < result.length; i++) {
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
