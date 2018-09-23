package sapient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpecialArrayConversion {

    private static boolean[] sievePrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int factor = 2; factor * factor <= n; factor++) {
            if (isPrime[factor]) {
                for (int j = factor; factor * j <= n; j++) {
                    isPrime[factor * j] = false;
                }
            }
        }

        return isPrime;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] isPrime = SpecialArrayConversion.sievePrimes(1_000_000);

        List<Integer> primeList = new ArrayList<>();
        List<Integer> otherList = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            int num = sc.nextInt();
            if (isPrime[num]) {
                primeList.add(num);
            } else {
                otherList.add(num);
            }
        }

        primeList.sort(Integer::compareTo);
        otherList.sort(Integer::compareTo);

        StringBuilder builder = new StringBuilder();
        for (Integer prime : primeList) {
            builder.append(prime).append(" ");
        }
        for (int i = otherList.size() - 1; i >= 0; i--) {
            builder.append(otherList.get(i)).append(" ");
        }
        System.out.print(builder.toString());
    }
}
