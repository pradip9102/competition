package hackerrank.sample;

import java.util.Scanner;

public class FindNum {
    private static final Scanner scanner = new Scanner(System.in);

    static String findNumber(int[] arr, int k) {
        for (int anArr : arr) {
            if (anArr == k) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) throws Exception {
        int arrCount = scanner.nextInt();
    }
}
