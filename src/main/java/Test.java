import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Test {

    public static void main(String args[]) throws Exception {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);

        LocalDate date = LocalDate.of(2015, 5, 8);
        System.out.println(date.getDayOfWeek().name());


        System.out.println();
        System.out.println();

        Scanner sc = new Scanner(System.in);
        double payment = 12324.134;//scanner.nextDouble();
        sc.close();

        // Write your code here.
        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        String india = NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(payment);
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);

        String IP = sc.next();
        System.out.println(IP.matches(new MyRegex().pattern));

        System.out.println(3/0);
    }
}

class MyRegex {
    private static final String TFF = "([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
    private static final String DOT = "\\.";

    public String pattern = "^" + TFF + DOT + TFF + DOT + TFF + DOT + TFF + "$";
}