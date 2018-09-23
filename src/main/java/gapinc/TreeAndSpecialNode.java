package gapinc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Tree {
    private Map<Integer, Node> _nodes;
    private Map<Integer, Edge> _paths;
    private Integer _totalNode;

    Tree(int nNode) {
        _totalNode = nNode;
        _nodes = new HashMap<>(_totalNode);
        _paths = new HashMap<>(_totalNode);
    }

    public Integer getTotalNode() {
        return _totalNode;
    }

    public void addNode(Integer value) {
        Node node = new Node(value);
        _nodes.put(node.getId(), node);
    }
}

class Node {
    private static Integer _counter = 0;
    private Integer _id;
    private Integer _value;

    Node(Integer value) {
        _id = ++_counter;
        _value = value;
    }

    public Integer getId() {
        return _id;
    }

    public Integer getValue() {
        return _value;
    }
}

class Edge {
    private Node _from;
    private Node _to;
    private Integer cost;
}

public class TreeAndSpecialNode {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Tree tree = new Tree(scanner.nextInt());
        for (int i = 0; i < tree.getTotalNode(); i++) {
            tree.addNode(scanner.nextInt());
        }
        for (int i = 0; i < tree.getTotalNode()-1; i++) {

        }
    }

}
