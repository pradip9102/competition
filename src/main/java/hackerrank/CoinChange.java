package hackerrank;

import java.util.Scanner;

public class CoinChange {

    private int[] waysToChangeCoin;
    private boolean[] availableCoins;

    private CoinChange() {
        availableCoins = new boolean[51];
        waysToChangeCoin = new int[251];
        for (int i = 1; i < waysToChangeCoin.length; i++) {
            waysToChangeCoin[i] = -1;
        }
    }

    private int getWays(int amount) {
        // amount is already 0
        if (amount == 0) {
            return 0;
        }

        // check if ways to make change is already known
        if (waysToChangeCoin[amount] >= 0) {
            return waysToChangeCoin[amount];
        }

        // calculate ways to make change
        // TODO: check if int data type is sufficient to hold the result
        int result = availableCoins[amount] ? 1 : 0;
        for (int i = 1, j = amount - i; i <= j; i++, j--) {
            result += getWays(i) * getWays(j);
        }

        return waysToChangeCoin[amount] = result;
    }


    public static void main(String[] args) throws Exception {
        CoinChange problem = new CoinChange();

        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            problem.availableCoins[sc.nextInt()] = true;
        }

        System.out.println(problem.getWays(amount));
    }
}
