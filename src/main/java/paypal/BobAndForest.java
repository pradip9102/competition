package paypal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BobAndForest {

    private int _forestWidth;
    private int _forestLength;
    private int[][] _forest;
    private Map<Integer, Long> _counts;

    private BobAndForest(int width, int length) {
        _forestWidth = width;
        _forestLength = length;
        _forest = new int[_forestWidth][_forestLength];
        _counts = new HashMap<>(_forestLength > _forestWidth ? _forestLength : _forestWidth);
    }

    private void initForest(Scanner scanner) {
        for (int r = 0; r < _forestWidth; r++) {
            String line = scanner.next();
            _forest[r][0] = ('*' == line.charAt(0)) ? 1 : 0;
            for (int c = 1; c < _forestLength; c++) {
                _forest[r][c] = _forest[r][c - 1] + (('*' == line.charAt(c)) ? 1 : 0);
            }
        }
    }

    private long countFilledSquare(int size) {
        Long result = _counts.get(size);
        if (result != null) {
            return result;
        }

        result = 0L;
        if (size == 1) {
            for (int r = 0; r < _forestWidth; r++) {
                result += _forest[r][_forestLength - 1];
            }
        } else if (size <= _forestWidth && size <= _forestLength) {
            // TODO:
        }

        _counts.put(size, result);
        return result;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        BobAndForest prob = new BobAndForest(scanner.nextInt(), scanner.nextInt());
        prob.initForest(scanner);

        int nQuery = scanner.nextInt();

        Map<Integer, Long> result = new HashMap<>();
        for (int q = 0; q < nQuery; q++) {
            System.out.println(prob.countFilledSquare(scanner.nextInt()));
        }
    }
}
