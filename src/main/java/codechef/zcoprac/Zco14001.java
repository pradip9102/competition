package codechef.zcoprac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Crane {
    private final int maxX, maxY;
    private final List<Integer> piles;
    private int currPos = 0;
    private int holding = -1;

    Crane(int maxWidth, int maxHeight, List<Integer> piles) {
        maxX = maxWidth - 1;
        maxY = maxHeight - 1;
        this.piles = piles;
    }

    void perform(int command) {
        switch (command) {
            case 0: // quit
                // TODO: UNDEFINED
                break;
            case 1: // move left
                if (currPos > 0) {
                    --currPos;
                }
                break;
            case 2: // move right
                if (currPos < maxX) {
                    ++currPos;
                }
                break;
            case 3: // pick up
                if (holding < 0 && piles.get(currPos) > 0) {
                    holding = currPos;
                    piles.set(currPos, piles.get(currPos) - 1);
                }
                break;
            case 4: // drop off
                if (holding >= 0 && piles.get(currPos) <= maxY) {
                    piles.set(currPos, piles.get(currPos) + 1);
                    holding = -1;
                }
                break;
            default:
                System.err.println("Unknown command: " + command);
        }
    }
}

public class Zco14001 {

    private enum Command {
        MOVE_LEFT(1),
        MOVE_RIGHT(2),
        PICK_UP(3),
        DROP_OFF(4),
        QUIT(0);

        private int code;

        Command(int code) {
            this.code = code;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // read dimension
        int stackCount = sc.nextInt();
        int maxHeight = sc.nextInt();

        // read piles
        List<Integer> piles = new ArrayList<>(stackCount);
        for (int i = 0; i < stackCount; i++) {
            piles.add(sc.nextInt());
        }

        // perform commands
        Crane crane = new Crane(stackCount, maxHeight, piles);
        for (int command = sc.nextInt(); command != 0; command = sc.nextInt()) {
            crane.perform(command);
        }

        // print result
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < stackCount; i++) {
            if (i != 0) {
                builder.append(" ");
            }
            builder.append(piles.get(i));
        }
        System.out.println(builder.toString());
    }
}
