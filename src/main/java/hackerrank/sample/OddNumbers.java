package hackerrank.sample;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class OddNumbers {
    private static final Scanner scanner = new Scanner(System.in);

    static int[] oddNums(int l, int r) {
        List<Integer> odds = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (i % 2 != 0) {
                odds.add(i);
            }
        }
        int[] arr = new int[odds.size()];
        for (int i = 0; i < odds.size(); i++) {
            arr[i] = odds.get(i);
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int r = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int[] res = oddNums(l, r);

        for (int resItr = 0; resItr < res.length; resItr++) {
            bufferedWriter.write(String.valueOf(res[resItr]));

            if (resItr != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
