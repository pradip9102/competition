package sapient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GameOfNumbers {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        long[] array = new long[N];
        long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
        for (int n = 0; n < N; n++) {
            array[n] = Long.parseLong(reader.readLine());
            if (max < array[n]) max = array[n];
            if (min > array[n]) min = array[n];
        }

        List<Integer> fx = new ArrayList<>();
        List<Integer> gx = new ArrayList<>();
        for (int x = 0; x < N; x++) {
            // check for global min or max
            if (array[x] == max) fx.add(-1);
            if (array[x] == min) gx.add(-1);

            for (int z = x + 1; z < N; z++) {
                if (fx.size() > x && gx.size() > x) break;

                // check for local min or max
                if (fx.size() == x && array[x] < array[z]) fx.add(z);
                if (gx.size() == x && array[x] > array[z]) gx.add(z);
            }

            if (fx.size() == x) fx.add(-1);
            if (gx.size() == x) gx.add(-1);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int j = fx.get(i) != -1 ? gx.get(fx.get(i)) : -1;
            long result = j != -1 ? array[j] : -1;
            builder.append(result).append((i + 1) < N ? " " : "\n");
        }
        System.out.print(builder.toString());
    }
}