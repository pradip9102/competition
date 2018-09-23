package hackerearth.krypc.mar18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GauravAndSubarray {

    private static Integer countSetBits(Integer num) {
        Integer count = 0;
        while (num > 0) {
            num &= (num - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int nElement = sc.nextInt(), nQuery = sc.nextInt();
        List<Integer> array = new ArrayList<>(nElement);
        array.add(0);
        for (int i = 1; i <= nElement; i++) {
            array.add(GauravAndSubarray.countSetBits(sc.nextInt()));
        }

        System.out.println(array.toString());

        for (int q = 0; q < nQuery; q++) {
            Integer min = sc.nextInt();
            Integer minLengthOverAll = Integer.MAX_VALUE;
            Integer sum = 0, start = 1;
            for (int end = 1; end <= nElement; end++) {
                sum += array.get(end);
                while (sum >= min && start <= end) {
                    Integer len = end - start + 1;
                    if (len < minLengthOverAll) minLengthOverAll = len;
                    sum -= array.get(start);
                    ++start;
                }
            }
            System.out.println(min + ":" + minLengthOverAll);
        }
    }
}
