package com.ta.may;


import java.util.*;

public class Day27Testing {

    public static int minimum_index(int[] seq) {
        if (seq.length == 0) {
            throw new IllegalArgumentException("Cannot get the minimum value index from an empty sequence");
        }
        int min_idx = 0;
        for (int i = 1; i < seq.length; ++i) {
            if (seq[i] < seq[min_idx]) {
                min_idx = i;
            }
        }
        return min_idx;
    }

    static class TestDataEmptyArray {
        public static int[] get_array() {
            int x[] = new int[0];
            return x;
        }
    }

    static class TestDataUniqueValues {
        public static int[] get_array() {
            // complete this function
            int x[] = {1, 2};
            return x;
        }

        public static int get_expected_result() {
            // complete this function
            return 0;
        }
    }

    static class TestDataExactlyTwoDifferentMinimums {
        public static int[] get_array() {
            // complete this function
            int x[] = {2,2};
            return x;
        }

        public static int get_expected_result() {
            // complete this function
            return 0;
        }
    }


}
