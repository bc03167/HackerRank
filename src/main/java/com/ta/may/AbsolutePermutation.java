package com.ta.may;


import java.io.*;
import java.util.*;

public class AbsolutePermutation {

    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {

        int pos[] = new int[n];

        for (int i = 0; i < pos.length; i++)
            pos[i] = i+1;


        List<List<Integer>> permute = permute(pos);

        for (List<Integer> perm : permute) {
            boolean isAbsolute = Boolean.TRUE;
            for (int i = 0; i < perm.size(); i++) {
                int p = perm.get(i);
                if (Math.abs(p - (i+1)) != k) {
                    isAbsolute = Boolean.FALSE;
                    break;
                }
            }
            if (isAbsolute) {
                return (perm.stream().mapToInt(i -> i).toArray());
            } else
                pos = null;
        }
        return pos;
    }

    static public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        permuteHelper(list, new ArrayList<>(), arr);
        return list;
    }

    static private void permuteHelper(
            List<List<Integer>> list,
            List<Integer> resultList,
            int [] arr){

        // Base case
        if(resultList.size() == arr.length){
            list.add(new ArrayList<>(resultList));
        }
        else{
            for(int i = 0; i < arr.length; i++){

                if(resultList.contains(arr[i]))
                {
                    // If element already exists in the list then skip
                    continue;
                }
                // Choose element
                resultList.add(arr[i]);
                // Explore
                permuteHelper(list, resultList, arr);
                // Unchoose element
                resultList.remove(resultList.size() - 1);
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] result = absolutePermutation(n, k);

            if (result == null) {
                bufferedWriter.write("-1");
                System.out.println("-1"+" ");
            } else {
                for (int i = 0; i < result.length; i++) {
                    System.out.print(result[i]+" ");
                    bufferedWriter.write(String.valueOf(result[i]));

                    if (i != result.length - 1) {
                        bufferedWriter.write(" ");
                    }
                }
                System.out.println();
            }
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
