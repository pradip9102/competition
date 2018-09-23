package hackerearth.congnizant;

import java.util.Scanner;

public class StringOperations {

    private StringOperations() {

    }

    public static void main(String[] args) throws Exception {
        StringOperations problem = new StringOperations();
        Scanner sc = new Scanner(System.in);

        StringBuilder S = new StringBuilder().append(sc.next());

        for (int q = sc.nextInt(); q > 0; q--) {
            S.setCharAt(sc.nextInt() - 1, sc.next().charAt(0));
        }
        String str = S.toString();

        for (int m = sc.nextInt(); m > 0; m--) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            S.replace(a, b + 1, new StringBuilder(S.substring(a, b + 1)).reverse().toString());
        }
        String fin = S.toString();

        int ni = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == fin.charAt(i)) {
                ++ni;
            }
        }

        System.out.println(str);
        System.out.println(fin);
        System.out.println(ni);
    }
}
