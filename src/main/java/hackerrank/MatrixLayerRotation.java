package hackerrank;

import java.util.LinkedList;
import java.util.Scanner;

public class MatrixLayerRotation {

    private static int getLayers(int maxr, int maxc) {
        int min = maxr < maxc ? maxr : maxc;
        return (min + 1) / 2;
    }

    private static int getSteps(int maxr, int maxc, int layer) {
        if (layer < getLayers(maxr, maxc)) {
            int rSteps = maxr - 2 * layer + 1;
            int cSteps = maxc - 2 * layer + 1;
            return 2 * rSteps + 2 * cSteps - 4;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int maxr = sc.nextInt() - 1;
        int maxc = sc.nextInt() - 1;
        int nRotation = sc.nextInt();

        int[][] matrix = new int[maxr+1][maxc+1];
        for (int r = 0; r <= maxr; r++) {
            for (int c = 0; c <= maxc; c++) {
                matrix[r][c] = sc.nextInt();
            }
        }

        for (int l = 0; l < getLayers(maxr, maxc); l++) {
            int tlr = l, tlc = l;
            int brr = maxr - l, brc = maxc - l;

            LinkedList<Integer> queue = new LinkedList<>();

            // add left line to stack
            for (int r = tlr; r < brr; r++) {
                queue.addLast(matrix[r][tlc]);
            }
            // add bottom line to stack
            for (int c = tlc; c < brc; c++) {
                queue.addLast(matrix[brr][c]);
            }
            // add right line to stack
            for (int r = brr; r > tlr; r--) {
                queue.addLast(matrix[r][brc]);
            }
            // add top line to stack
            for (int c = brc; c > tlc; c--) {
                queue.addLast(matrix[tlr][c]);
            }

            // rotate
            int nRotationEffective = nRotation % getSteps(maxr, maxc, l);
            for (int s = 0; s < nRotationEffective; s++) {
                queue.addFirst(queue.removeLast());
            }

            // add left line to stack
            for (int r = tlr; r < brr; r++) {
                matrix[r][tlc] = queue.removeFirst();
            }
            // add bottom line to stack
            for (int c = tlc; c < brc; c++) {
                matrix[brr][c] = queue.removeFirst();
            }
            // add right line to stack
            for (int r = brr; r > tlr; r--) {
                matrix[r][brc] = queue.removeFirst();
            }
            // add top line to stack
            for (int c = brc; c > tlc; c--) {
                matrix[tlr][c] = queue.removeFirst();
            }
        }

        // print rotated matrix
        for (int r = 0; r <= maxr; r++) {
            for (int c = 0; c <= maxc; c++) {
                System.out.print(matrix[r][c] + ((c != maxc) ? " " : "\n"));
            }
        }
    }
}
