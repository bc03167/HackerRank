import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class A3Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Long> arr) {
        // Write your code here
        Collections.sort(arr);
        long minSum=0, maxSum=0;
        for (int i = 0; i < 4; i++) {
            minSum += arr.get(i);
            //System.out.println(arr.get(i)+"added -->"+minSum);
        }
        for (int i = 4; i > 0; i--)
            maxSum += arr.get(i);
        System.out.println(minSum + " "+maxSum);

    }

}

public class MinMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        A3Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
