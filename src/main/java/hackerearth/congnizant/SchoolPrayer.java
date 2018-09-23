package hackerearth.congnizant;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SchoolPrayer {
    private List<Integer> line;

    private SchoolPrayer(int N) {
        line = new ArrayList<>(N);
    }

    private static int getPosition(SchoolPrayer prayer, Integer rollNumber) {
        if (prayer.line.isEmpty() || prayer.line.get(0) > rollNumber) {
            return 0;
        }

        if (prayer.line.get(prayer.line.size() - 1) < rollNumber) {
            return prayer.line.size();
        }

        int start = 0, end = prayer.line.size(), mid = (start + end) / 2;
        while (end - start > 1) {
            if (prayer.line.get(mid) < rollNumber) {
                start = mid;
                mid = (start + end) / 2;
            } else if (prayer.line.get(mid) > rollNumber) {
                end = mid;
                mid = (start + end) / 2;
            } else {
                System.err.println("Duplicate roll numbers found!");
                return Integer.MIN_VALUE;
            }
        }
        return start + 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int t = Integer.parseInt(reader.readLine()); t > 0; t--) {
            int N = Integer.parseInt(reader.readLine());

            SchoolPrayer prayer = new SchoolPrayer(N);
            String[] rollStrings = reader.readLine().trim().split(" ");
            long ans = 0L;
            for (int n = 0; n < N; n++) {
                int rollNumber = Integer.parseInt(rollStrings[n]);
                int position = getPosition(prayer, rollNumber);
                prayer.line.add(position, rollNumber);
                ans += position > 0 ? prayer.line.get(position - 1) : -1;
                //System.out.println(position + ": " + prayer.line);
            }

            System.out.println(ans);
        }
    }
}
