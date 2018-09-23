package techgig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

class Shape {}
class Rectangle extends Shape {}
class Circle extends Rectangle {}
class ConcreteCircle extends Circle {}
class MagicCircle extends ConcreteCircle {}

public class Tryout {

    public static void main(String[] args) {
        List<? extends Circle> list = null;

        list = new ArrayList<Circle>();
        list = new ArrayList<ConcreteCircle>();
        list = new ArrayList<MagicCircle>();

    }
}
