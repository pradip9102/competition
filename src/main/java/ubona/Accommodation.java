package ubona;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Accommodation {

    private static Integer LIMIT = 1_000_000_007;

    private static Integer findTotalWays(List<Integer> capacity, Integer index, Integer target) {
        // all elements are processed and target has not reached
        if (index >= capacity.size() || target < 0) {
            return 0;
        }

        // target reached
        if (target == 0) {
            return 1;
        }

        return (findTotalWays(capacity, index, target - capacity.get(index))
                + findTotalWays(capacity, index + 1, target)) % LIMIT;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Integer floorCount = sc.nextInt();
        Integer personCount = sc.nextInt();
        List<Integer> capacity = new ArrayList<>();
        for (int i = 0; i < floorCount; i++) {
            capacity.add(sc.nextInt());
        }

        capacity.sort(Integer::compareTo);

        System.out.println(Accommodation.findTotalWays(capacity, 0, personCount));
    }
}
