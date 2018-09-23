package hackerearth.lenskart;

import java.util.Scanner;

public class MaxPower {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = sc.nextInt(); t > 0; t--) {
            int n = sc.nextInt();
            int min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();

                if (min == Integer.MAX_VALUE || a[min] > a[i]) {
                    min2 = min;
                    min = i;
                }

                if (max == Integer.MIN_VALUE || a[max] < a[i]) {
                    max2 = max;
                    max = i;
                }
            }

            int power;
            if (max == 0 && min == n - 1 && n > 2) {
                int power2 = (max2 != Integer.MIN_VALUE) ? (a[max2] - a[min]) : Integer.MIN_VALUE;
                int power3 = (min2 != Integer.MAX_VALUE) ? (a[max] - a[min2]) : Integer.MIN_VALUE;
                power = Math.max(power2, power3);
            } else {
                power = a[max] - a[min];
            }

            //System.out.println("min: " + min + "\nmax: " + max);
            System.out.println(power);
        }
    }
}
