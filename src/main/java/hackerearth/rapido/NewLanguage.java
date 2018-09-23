package hackerearth.rapido;

import java.util.*;

public class NewLanguage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int t = scanner.nextInt(); t > 0; t--) {
            String query = scanner.next();
            if (query.contains("+")) {
                String[] params = query.split("[+\\-*/]");
                NinjaNumber left = new NinjaNumber(Integer.valueOf(params[0]));
                NinjaNumber right = new NinjaNumber(Integer.valueOf(params[2]));
                switch (params[1]) {
                    case "+":
                        System.out.println(left.plus(right));
                        break;
                    case "-":
                        System.out.println(left.minus(right));
                        break;
                    case "*":
                        System.out.println(left.multiply(right));
                        break;
                    case "/":
                        System.out.println(left.divide(right));
                        break;
                }

                if (Objects.equals("+", params[1])) {
                    System.out.println(left.plus(right));
                }
            }


            query.indexOf("+");
        }
    }
}

class NinjaNumber {
    private static final Integer MISSING_DIGIT = 8;
    private Long decimalValue;

    public NinjaNumber(Integer ninjaValue) {
        this(ninjaValue.longValue());
    }

    public NinjaNumber(Long ninjaValue) {
        decimalValue = decimalValueOf(ninjaValue);
    }

    /**
     * @return the ninja value
     */
    public Long value() {
        return ninjaValueOf(decimalValue);
    }

    public NinjaNumber plus(NinjaNumber other) {
        return new NinjaNumber(this.decimalValue + other.decimalValue);
    }

    public NinjaNumber minus(NinjaNumber other) {
        return new NinjaNumber(this.decimalValue - other.decimalValue);
    }

    public NinjaNumber multiply(NinjaNumber other) {
        return new NinjaNumber(this.decimalValue * other.decimalValue);
    }

    public NinjaNumber divide(NinjaNumber other) {
        return new NinjaNumber(this.decimalValue / other.decimalValue);
    }

    private static Long ninjaValueOf(Long decimalValue) {
        long amount = decimalValue + (decimalValue / 9);
        int remnant = amount % 10 >= MISSING_DIGIT ? 1 : 0;
        return amount + remnant;
    }

    private static Long decimalValueOf(Long ninjaValue) {
        int remnant = ninjaValue % 10 > MISSING_DIGIT ? 1 : 0;
        long temp = ninjaValue - remnant;
        return temp - (temp / 10);
    }
}

abstract class Expression {
    abstract NinjaNumber perform(NinjaNumber left, NinjaNumber right);
}

class Addition extends Expression {
    @Override
    NinjaNumber perform(NinjaNumber left, NinjaNumber right) {
        return left.plus(right);
    }
}