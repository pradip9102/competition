package hackerearth.capillary;

import java.util.*;

public class BinaryMatrix {

    private static int compare(String left, String right, int length) {
        for (int i = 0; i < length; i++) {
            if (left.charAt(i) == '1' && right.charAt(i) == '0') {
                return -1;
            } else if (left.charAt(i) == '0' && right.charAt(i) == '1') {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCount = scanner.nextInt();
        int length = scanner.nextInt();

        List<String> nums = new ArrayList<>(numCount);
        for (int i = 0; i < numCount; i++) {
            nums.add(scanner.next());
        }

        int maxValuedRow = 0;
        for (int r = 1; r < numCount; r++) {
            if (compare(nums.get(maxValuedRow), nums.get(r), length) > 0) {
                maxValuedRow = r;
            }
        }

        System.out.println(maxValuedRow + 1);
    }
}
