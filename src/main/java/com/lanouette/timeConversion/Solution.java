package com.lanouette.timeConversion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scan = new Scanner(System.in);

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        String[] parts = s.split(":");
        if (parts.length != 3) {
            // error case, what should we do?
            return s;
        }
        boolean isAm = parts[2].substring(2).toUpperCase().equals("AM");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        int second = Integer.parseInt(parts[2].substring(0, 2));

        // special case -  Midnight is 12:00:00AM
        if (isAm && hour == 12) {
            hour = 0;
        }
        // special case - Noon is 12:00:00PM
        if (!isAm && hour < 12) {
            hour += 12;
        }

        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
