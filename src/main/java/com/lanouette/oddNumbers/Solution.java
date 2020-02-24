package com.lanouette.oddNumbers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Result {

    /*
     * Complete the 'oddNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER l
     *  2. INTEGER r
     */
    public static List<Integer> oddNumbers(int l, int r) {
        // System.out.printf("l=%d, r=%d, isOdd=%b\n", l, r, isOdd(l));
        int start = isOdd(l) ? l : ++l;
        int end = isOdd(r) ? r : ++r;

        List<Integer> results = new ArrayList<Integer>();

        for (int i = start; i <= end; i += 2) {
            results.add(i);
        }

        return results;
    }

    static boolean isOdd(int i) {
        return Math.abs(i % 2) == 1;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> results = Result.oddNumbers(2, 5);
        if (results.size() == 2 && results.get(0) == 3 && results.get(1) == 5) {
            System.out.println("Horray!");
        } else {
            System.out.println("OOPS");
            System.out.println(results);
        }

        results = Result.oddNumbers(1, 5);
        if (results.size() == 3 && results.get(0) == 1 && results.get(1) == 3 && results.get(2) == 5) {
            System.out.println("Horray!");
        } else {
            System.out.println("OOPS");
            System.out.println(results);
        }
    }
}
