package paypal;

import java.util.Scanner;

public class EvenLengthPalindromicNumber {

    private static int[] getDigitCounts(long num) {
        int[] counts = new int[10];
        while (num > 0) {
            ++counts[(int) (num % 10)];
            num /= 10;
        }
        return counts;
    }

    private static int getMaxRepetedDigit(long num) {
        int[] counts = getDigitCounts(num);
        int maxRepeatedDigit = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > counts[maxRepeatedDigit]) {
                maxRepeatedDigit = i;
            }
        }
        return maxRepeatedDigit;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        for (int t = scanner.nextInt(); t > 0; t--) {
            System.out.println(getMaxRepetedDigit(scanner.nextLong()));
        }
    }
}
