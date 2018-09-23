package hackerearth.redlock;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayAndMagicValue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer length = scanner.nextInt();
        int[] originalArray = new int[length];
        for (int i = 0; i < length; i++) {
            originalArray[i] = scanner.nextInt();
        }
        int[] sortedArray = originalArray.clone();
        Arrays.sort(sortedArray);

        long goodSum = 0L;
        long badSum = 0L;
        for (int i = 0; i < length; i++) {
            if (originalArray[i] == sortedArray[i]) {
                goodSum += originalArray[i];
            } else {
                badSum += originalArray[i];
            }
        }

        System.out.println(goodSum - badSum);
    }
}
