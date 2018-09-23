package hackerearth.kellton;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coins {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bagCount = scanner.nextInt();
        List<Integer> coinsInBag = new ArrayList<>(bagCount);
        for (int i = 0; i < bagCount; i++) {
            coinsInBag.set(i, scanner.nextInt());
        }

        coinsInBag.sort(Integer::compareTo);

        List<Long> summedCoins = new ArrayList<>();
        summedCoins.add(Long.valueOf(coinsInBag.get(0)));
        for (int i = 1; i < coinsInBag.size(); i++) {
            if (coinsInBag.get(i).equals(coinsInBag.get(i - 1))) {
                summedCoins.set(summedCoins.size() - 1, summedCoins.get(summedCoins.size() - 1) + coinsInBag.get(i));
            } else {
                summedCoins.add(summedCoins.get(summedCoins.size() - 1) + coinsInBag.get(i));
            }
        }
    }
}
