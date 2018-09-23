package hackerearth.capillary;

import java.util.*;

public class OldAndColdNumbers {
    private int size;
    private List<Integer> array;
    private List<Integer> colds;

    private OldAndColdNumbers(int size) {
        this.size = size;
        array = new ArrayList<>(size + 1);
        colds = new ArrayList<>(size + 1);
        array.add(0);
        colds.add(0);
    }

    private boolean isCold(int num) {
        return num > 2 && (num & 1) == 1;
    }

    private void add(int num) {
        int i = array.size();
        array.add(num);
        colds.add(colds.get(i-1) + (isCold(num) ? 1 : 0));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int t = scanner.nextInt(); t > 0; t--) {
            OldAndColdNumbers prob = new OldAndColdNumbers(scanner.nextInt());
            for (int i = 1; i <= prob.size; i++) {
                prob.add(scanner.nextInt());
            }

            int queryCount = scanner.nextInt();
            for (int q = 0; q < queryCount; q++) {
                int left = scanner.nextInt();
                int right = scanner.nextInt();
                int coldCount = prob.colds.get(right) - prob.colds.get(left-1);
                int oldCount = right - left - coldCount + 1;
                System.out.println((oldCount >= coldCount) ? 0 : (int)Math.ceil((coldCount - oldCount)/2.0));
            }
        }
    }
}
