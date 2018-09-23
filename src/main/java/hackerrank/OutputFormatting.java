package hackerrank;

import java.util.Scanner;

public class OutputFormatting {

    private static String spaces(int n) {
        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            builder.append(" ");
            --n;
        }
        return builder.toString();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String str = sc.next();
            int x = sc.nextInt();
            System.out.println(String.format("%s%s%03d", str, OutputFormatting.spaces(15 - str.length()), x));
        }
        System.out.println("================================");
    }
}
