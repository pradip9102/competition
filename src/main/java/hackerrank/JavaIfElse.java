package hackerrank;

import java.util.Scanner;

public class JavaIfElse {

    private static final String TEXT_WEIRD = "Weird";
    private static final String TEXT_NOT_WEIRD = "Not Weird";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        if (n % 2 != 0) {
            System.out.println(TEXT_WEIRD);
        } else {
            if (2 <= n && n <= 5) {
                System.out.println(TEXT_NOT_WEIRD);
            } else if (6 <= n && n <= 20) {
                System.out.println(TEXT_WEIRD);
            } else if (n > 20) {
                System.out.println(TEXT_NOT_WEIRD);
            }
        }
    }
}
