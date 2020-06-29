
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;

public class ListListSort {
    public static void main(String [] args) throws IOException {
        final int maxValue = 100;

        /* Create HashMap with empty "buckets" to put Strings into */
        HashMap<Integer, ArrayList<String>> map = new HashMap<>(maxValue);
        for (int i = 0; i < maxValue; i++) {
            map.put(i, new ArrayList<String>());
        }

        /* Save input */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String [] pair = br.readLine().split(" ");
            int key        = Integer.parseInt(pair[0]);
            String value   = (i < n/2) ? "-" : pair[1];

            ArrayList<String> list = map.get(key);
            list.add(value);
        }
        br.close();

        /* Print output */
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < maxValue; i++) {
            ArrayList<String> values = map.get(i);
            for (String str : values) {
                sb.append(str + " ");
            }
        }
        System.out.println(sb);
    }
}


/*
import java.io.*;

import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ListListSort {

    // Complete the countSort function below.
    static void countSort(List<List<String>> arr) {
        Map<Integer, String> m = new HashMap<>();
        int n = arr.size();
        for (int i = 0; i < n/2; i++) {
            arr.get(i).set(1,"-");
        }
        for (int i=0; i < n; i++) {
            List iL = arr.get(i);
            Integer key = Integer.parseInt((String)iL.get(0));
            String orig = m.get(key);
            orig = (orig == null) ? "" : orig;

            m.put(key, orig+" "+iL.get(1) );
        }

        StringBuffer answer = new StringBuffer("");
        for (int i = 0; i <n; i++) {
            String o = (m.get(i));
            if (o == null)
                continue;
            answer.append(o);
        }
        System.out.println(answer.substring(1));


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Arrays.asList(
                    bufferedReader.readLine()
                            .replaceAll("\\s+$", "")
                            .split(" ")
                    )
            );


        }

        countSort(arr);

        bufferedReader.close();
    }
}

 */

