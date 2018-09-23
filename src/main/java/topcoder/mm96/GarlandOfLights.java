package topcoder.mm96;

public class GarlandOfLights {

    enum Light {
        A('a'), B('b'), C('c'), D('d');

        private char color;

        Light(char color) {
            this.color = color;
        }
    }

    enum Side {
        TOP, RIGHT, BOTTOM, LEFT;
    }

    enum Configuration {
        ZERO(0, Side.RIGHT, Side.BOTTOM),
        ONE(1, Side.BOTTOM, Side.LEFT),
        TWO(2, Side.LEFT, Side.TOP),
        THREE(3, Side.TOP, Side.RIGHT),
        FOUR(4, Side.LEFT, Side.RIGHT),
        FIVE(5, Side.TOP, Side.BOTTOM);

        private int confType;
        private Side wire1;
        private Side wire2;

        Configuration(int confType, Side wire1, Side wire2) {
            this.confType = confType;
            this.wire1 = wire1;
            this.wire2 = wire2;
        }
    }

    class Tile {

        Light light;
        Configuration config;

        Tile(char l, int c) {
//            light = Light.valueOf(l.toUpperCase());
        }
    }

    public int[] create(int height, int width, String[] lights) {
        int[] result = new int[height * width];

        // TODO

        return result;
    }
}
