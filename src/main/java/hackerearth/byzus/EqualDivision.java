package hackerearth.byzus;

import java.util.*;

public class EqualDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int teamCount = scanner.nextInt();
        List<Integer> memberCounts = new ArrayList<>(teamCount);
        List<Integer> revisedBudgets = new ArrayList<>(teamCount);
        for (int t = 0; t < teamCount; t++) {
            int teamBudget = scanner.nextInt();
            int memberCount = scanner.nextInt();
            revisedBudgets.add(teamBudget % memberCount);
            memberCounts.add(memberCount);
        }

        long revisions = 0;
        for (int i = teamCount - 1; i >= 0; i--) {
            long currentRevisedBudget = (revisedBudgets.get(i) + revisions) % memberCounts.get(i);
            revisions += (memberCounts.get(i) - currentRevisedBudget) % memberCounts.get(i);
        }
        System.out.println(revisions);
    }
}
