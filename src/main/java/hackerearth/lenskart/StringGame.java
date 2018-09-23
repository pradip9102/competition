package hackerearth.lenskart;

import java.util.Scanner;

public class StringGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = sc.nextInt(); t > 0; t--) {
            String str = sc.next();
            boolean[] availableChars = new boolean[27];
            for (int i = 0; i < str.length(); i++) {
                availableChars[Character.getNumericValue(str.charAt(i)) - Character.getNumericValue('a')] = true;
            }

            int count = 0;
            for (boolean available : availableChars) {
                if (available) ++count;
            }

            if (count % 2 != 0)
                System.out.println("Player1");
            else
                System.out.println("Player2");
        }
    }
}
