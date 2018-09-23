package vivriti;

import java.util.Scanner;

public class TediousWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] wt = new int[n];
        int[] ct = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ct[i] = scanner.nextInt();
        }


    }
}
