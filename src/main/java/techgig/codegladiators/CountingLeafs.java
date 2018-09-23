package techgig.codegladiators;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
    int nodeId;
    List<Node> children;

    Node(Integer value) {
        this.nodeId = value;
        children = new ArrayList<>();
    }
}

public class CountingLeafs {

    private static final int MAX_NODE_COUNT = 100;

    private static Integer countLeafs(Node parent, int deprecatedNodeId) {
        if (parent.nodeId == deprecatedNodeId) {
            return 0;
        }

        if (parent.children.isEmpty()) {
            return 1;
        }

        int leafCount = 0;
        for (Node child : parent.children) {
            leafCount += countLeafs(child, deprecatedNodeId);
        }
        return leafCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Node> nodes = new ArrayList<>(MAX_NODE_COUNT);
        for (int i = 0; i < MAX_NODE_COUNT; i++) {
            nodes.add(new Node(i));
        }

        int nodeCount = scanner.nextInt();
        Node parent = null;
        for (int i = 0; i < nodeCount; i++) {
            int ai = scanner.nextInt();
            if (ai == -1) {
                parent = nodes.get(i);
            } else {
                nodes.get(ai).children.add(nodes.get(i));
            }
        }

        int deprecatedNodeId = scanner.nextInt();
        assert parent != null;
        System.out.println(countLeafs(parent, deprecatedNodeId));
    }
}
