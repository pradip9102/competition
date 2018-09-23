package hackerearth.creditsuisse;

import java.util.*;

public class _NiceQueries {
    private List<Integer> array;

    private _NiceQueries(Integer length) {
        array = new ArrayList<>(length + 1);
        for (int i = 0; i <= length; i++) {
            array.add(0);
        }
    }

    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);

        Integer N = s.nextInt();
        Integer Q = s.nextInt();
        _NiceQueries problem = new _NiceQueries(N);
        for (int q = 1; q <= Q; q++) {
            Integer type = s.nextInt();
            if (type == 1) {
                Integer k = s.nextInt();
                problem.array.add(k, k);
            } else if (type == 2) {
                Integer y = s.nextInt();
                Integer x = 0;
                for (int i = y; i <= N; i++) {
                    if (problem.array.get(i) > 0) {
                        x = i;
                        break;
                    }
                }
                System.out.println(x != 0 ? x : -1);
            }
        }
    }
}
