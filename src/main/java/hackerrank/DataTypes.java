package hackerrank;

import java.util.Scanner;

public class DataTypes {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            String str = sc.next();
            boolean isByte = false, isShort = false, isInt = false, isLong = false;
            try {
                new Long(str);
                isLong = true;

                new Integer(str);
                isInt = true;

                new Short(str);
                isShort = true;

                new Byte(str);
                isByte = true;
            } catch (Exception e) {
                if (isByte || isShort || isInt || isLong) {
                    System.out.println(str + " can be fitted in:");
                    if (isByte) {
                        System.out.println("* byte");
                    }
                    if (isShort) {
                        System.out.println("* short");
                    }
                    if (isInt) {
                        System.out.println("* int");
                    }
                    if (isLong) {
                        System.out.println("* long");
                    }
                } else {
                    System.out.println(str + " can't be fitted anywhere.");
                }
            }
        }
    }
}
