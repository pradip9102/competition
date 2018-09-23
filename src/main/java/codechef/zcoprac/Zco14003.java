package codechef.zcoprac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zco14003 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Integer> budgets = new ArrayList<>();
        for (int n = sc.nextInt(); n > 0; n--) {
            budgets.add(sc.nextInt());
        }
        budgets.sort(Integer::compareTo);

        Long maxRevenue = 0L;
        for (int i = 0; i < budgets.size(); i++) {
            Long revenue = budgets.get(i).longValue() * (budgets.size() - i);
            if (revenue > maxRevenue) {
                maxRevenue = revenue;
            }
        }
        System.out.println(maxRevenue);
    }
}
