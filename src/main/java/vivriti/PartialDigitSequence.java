package vivriti;

import java.util.Scanner;

public class PartialDigitSequence {

    private static int getDigits(long num) {
        int result = 0;
        while (num > 0) {
            long digit = num % 10;
            result |= 1 << digit;
            num /= 10;
        }
        return result;
    }

    private static boolean hasCommonDigits(int x, int y) {
        return (x & y) > 0;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int gmax = 0, lmax = 0;
        int prev, curr = Integer.MAX_VALUE;

        for (int n = scanner.nextInt(); n > 0; n--) {
            prev = curr;
            curr = getDigits(scanner.nextLong());

            if (hasCommonDigits(prev, curr)) {
                ++lmax;
            } else {
                lmax = 1;
            }

            if (gmax < lmax) {
                gmax = lmax;
            }
        }

        System.out.println(gmax);
    }
}
