package com.lanouette.extraLongFactorials;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        BigInteger b = calculateFactorial(n);

        System.out.println(b.toString());
    }

    static BigInteger calculateFactorial(int n) {
        assert n > 0;

        BigInteger b = BigInteger.valueOf(1);

        for (int i = 1; i <= n; i++) {
            b = b.multiply(BigInteger.valueOf(i));
        }
        return b;
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
