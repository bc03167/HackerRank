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

class Result {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code
        Map<String, Integer> magMap = new ConcurrentHashMap<>();
        Map<String, Integer> noteMap = new ConcurrentHashMap<>();

        Integer count = 0;
        for (String vocab : magazine) {
            if ( magMap.get(vocab) != null) {
                count = magMap.get(vocab);
                magMap.put(vocab, ++count);
            } else {
                magMap.put(vocab, 1);
            }
        }
        for (String vocab : note) {
            if ( noteMap.get(vocab) != null) {
                count = noteMap.get(vocab);
                noteMap.put(vocab, ++count);
            } else {
                noteMap.put(vocab, 1);
            }
        }

        Set<String> noteKeys = noteMap.keySet();
        for (String noteKey : noteKeys) {
            if (magMap.get(noteKey) == null) {
                System.out.println("No");
                return;
            }
            if (magMap.get(noteKey) < noteMap.get(noteKey)) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");

    }

}


public class HRHashMap {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
