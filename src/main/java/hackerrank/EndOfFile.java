package hackerrank;

import java.util.Scanner;

public class EndOfFile {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while (sc.hasNext()) {
            System.out.println(++i + " " + sc.nextLine());
        }
    }
}
