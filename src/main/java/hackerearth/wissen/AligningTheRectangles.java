package hackerearth.wissen;

import java.util.*;

public class AligningTheRectangles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer rectangleCount = scanner.nextInt();
//        List<WissenRectangle> rectangles = new ArrayList<>(rectangleCount);
        PriorityQueue<WissenRectangle> rectangles = new PriorityQueue<>(rectangleCount);
        for (int i = 0; i < rectangleCount; i++) {
            rectangles.add(new WissenRectangle(scanner.nextInt(), scanner.nextInt()));
        }

        while (!rectangles.isEmpty()) {
            System.out.println(rectangles.poll().toString());
        }
    }
}

class WissenRectangle implements Comparable {
    private Integer length;
    private Integer breadth;

    WissenRectangle(Integer length, Integer breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public String toString() {
        return length + " " + breadth;
    }

    @Override
    public int compareTo(Object o) {
        WissenRectangle other = o instanceof WissenRectangle ? (WissenRectangle) o : null;
        if (this.length < other.length) {
            return -1;
        }

        if (this.length > other.length) {
            return 1;
        }

        if (this.breadth < other.breadth) {
            return 1;
        }

        if (this.breadth > other.breadth) {
            return -1;
        }

        return 0;
    }
}