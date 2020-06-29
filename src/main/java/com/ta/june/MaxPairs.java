package com.ta.june;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;


public class MaxPairs {

    /*
     * Complete the 'maxPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY skillLevel
     *  2. INTEGER minDiff
     */

    public static int maxPairs(List<Integer> skillLevel, int minDiff) {
        // Write your code here
        Map<Integer, Integer> m = new HashMap<>();
        int _diff = -1;

        for (int i = 0; i < skillLevel.size(); i++) {

            Integer ii = skillLevel.get(i);
            for (int j = i + 1; j < skillLevel.size(); j++) {
                Integer jj = skillLevel.get(j);

                _diff = Math.abs(ii-jj);
                if (_diff >= minDiff) {
                    m.put(jj, ii);
                }
            }
        }
        return m.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH"))
        );

        int skillLevelCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> skillLevel = IntStream.range(0, skillLevelCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int minDiff = Integer.parseInt(bufferedReader.readLine().trim());

        int result = MaxPairs.maxPairs(skillLevel, minDiff);
        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}





