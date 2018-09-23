package hackerrank;

import java.util.Scanner;

public class Loops2 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        while (q > 0) {
            --q;
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                System.out.print((a + (b * ((1 << i) - 1))) + ((i != n) ? " " : "\n"));
            }
        }

        sc.close();
    }
}
