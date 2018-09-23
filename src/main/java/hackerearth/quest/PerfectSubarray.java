package hackerearth.quest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerfectSubarray {

    private static boolean isPerfectSquare(double num) {
        double sqRoot = Math.sqrt(num);
        return sqRoot - Math.floor(sqRoot) == 0;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Integer arraySize = scanner.nextInt();
        List<Double> sums = new ArrayList<>(arraySize+1);
        sums.add(0.0);
        for (int i = 1; i <= arraySize; i++) {
            sums.add(sums.get(i-1) + Integer.valueOf(scanner.nextInt()).doubleValue());
        }

        long perfectSquares = 0;
        for (int start = 1; start <= arraySize; start++) {
            for (int end = start; end <= arraySize; end++) {
                if (isPerfectSquare(sums.get(end) - sums.get(start-1))) {
                    ++perfectSquares;
                }
            }
        }

        System.out.println(perfectSquares);
    }
}
