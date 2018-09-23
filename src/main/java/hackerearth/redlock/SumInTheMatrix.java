package hackerearth.redlock;

import java.util.Arrays;
import java.util.Scanner;

public class SumInTheMatrix {

    private static int binSearchStartPos(long[] array, long num) {
        int start = 0;
        int end = array.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (start == mid && mid == end) {
                return array[mid] >= num ? mid : (mid+1);
            }
            mid = (start + end) / 2;
            if (num < array[mid]) {
                end = mid - 1;
            } else if (num > array[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return (start < array.length) && (array[start] >= num) ? start : -1;
    }

    private static int binSearchEndPos(long[] array, long num) {
        int start = 0;
        int end = array.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (start == mid && mid == end) {
                return array[mid] <= num ? mid : (mid-1);
            }
            mid = (start + end) / 2;
            if (num < array[mid]) {
                end = mid - 1;
            } else if (num > array[mid]) {
                start = mid + 1;
            } else {
                start = mid;
            }
        }
        return (end >= 0) && (array[end] <= num) ? end : -1;
    }

    private static int countBetween(long[] array, long leftVal, long rightVal) {
        int start = binSearchStartPos(array, leftVal);
        int end = binSearchEndPos(array, rightVal);
        if (start == -1) {
            return leftVal < array[0] ? array.length : 0;
        } else if (end == -1) {
            return rightVal < array[0] ? 0 : array.length;
        } else {
            return end - start + 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nRow = scanner.nextInt();
        int nCol = scanner.nextInt();
        long[] rowSum = new long[nRow];
        long[] colSum = new long[nCol];

        for (int r = 0; r < nRow; r++) {
            for (int c = 0; c < nCol; c++) {
                int num = scanner.nextInt();
                rowSum[r] += num;
                colSum[c] += num;
            }
        }

        Arrays.sort(rowSum);
        Arrays.sort(colSum);

        int nQuery = scanner.nextInt();
        int temp = scanner.nextInt();
        for (int q = 0; q < nQuery; q++) {
            long left = scanner.nextLong();
            long right = scanner.nextLong();
            long resutl = countBetween(rowSum, left, right) + countBetween(colSum, left, right);
            System.out.print((q >0 ? " " : "") + resutl);
        }
    }
}
