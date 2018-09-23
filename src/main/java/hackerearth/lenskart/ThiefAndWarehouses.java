package hackerearth.lenskart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThiefAndWarehouses {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = sc.nextInt(); t > 0; t--) {
            int whCount = sc.nextInt();
            List<Long> sackCounts = new ArrayList<>(whCount);
            for (int n = 0; n < whCount; n++) {
                sackCounts.add(sc.nextLong());
            }

            sackCounts.sort(Long::compareTo);

            Long max = Long.MIN_VALUE;
            for (int n = 0; n < whCount; n++) {
                Long quantity = sackCounts.get(n) * (whCount - n);
                if (max < quantity) max = quantity;
            }

            System.out.println(max);
        }
    }
}
