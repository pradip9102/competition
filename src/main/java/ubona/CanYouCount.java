package ubona;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CanYouCount {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int t = sc.nextInt(); t > 0; t--) {
            String str = sc.next();

            Long distinctWays = 1L;
            Set<Character> vowels = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels.add(ch);
                } else if (ch == '_') {
                    distinctWays *= vowels.size();
                }
            }

            System.out.println(distinctWays);
        }
    }
}
