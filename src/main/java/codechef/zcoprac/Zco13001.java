package codechef.zcoprac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zco13001 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // read team details
        int teamCount = sc.nextInt();
        List<Integer> strengths = new ArrayList<>(teamCount + 1);
        strengths.add(-1); // to use 1-based indexing
        for (int t = 1; t <= teamCount; t++) {
            strengths.add(t, sc.nextInt());
        }

        // sort strengths
        strengths.sort(Integer::compareTo);
//        System.out.println(strengths);

        // total revenue = sumOfAll[i * (n-i) * diff(i+1, i)]    where 1 <= i < n for 1-based indexing
        long totalRevenue = 0L;
//        for (int i = 1; i < teamCount; i++) {
//            totalRevenue += i * (teamCount - i) * (strengths.get(i + 1) - strengths.get(i));
//        }
        for (int i = 1; i <= teamCount; i++) {
            totalRevenue += (2L * i - 1 - teamCount) * strengths.get(i);
        }

        // print result
        System.out.println(totalRevenue);
    }
}
