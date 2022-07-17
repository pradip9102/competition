import java.util.*;

import kotlin.Pair;

public class AdjList {
    private int nodeCount;
    private List<LinkedList<Pair<Integer, Integer>>> _adjacencies = new ArrayList<>();

    AdjList() {
        this(0);
    }

    private AdjList(Integer nodeCount) {
        this.nodeCount = nodeCount;
        for (int n = 0; n < nodeCount; n++) {
            _adjacencies.add(new LinkedList<>());
        }
    }

    void addEdge(int startNode, int endNode, int weight) {
        _adjacencies.get(startNode).add(new Pair<>(endNode + 1, weight));
    }

    int countNodes() {
        return _adjacencies.size();
    }

    int countEdgesFrom(int startNode) {
        return _adjacencies.get(startNode).size();
    }

    LinkedList<Pair<Integer, Integer>> getEdgesFrom(int startNode) {
        return _adjacencies.get(startNode);
    }

    boolean removeEdge(int startNode, Pair<Integer, Integer> edge) {
        return _adjacencies.get(startNode - 1).remove(edge);
    }

    boolean hasEdge(int startNode, int endNode, int weight) {
        return _adjacencies.get(startNode).contains(new Pair<>(endNode, weight));
    }

    void printAdjacencies() {
        for (int i = 0; i < _adjacencies.size(); i++) {
            System.out.print("adjancencies[" + (i + 1) + "] -> ");
            for (Pair<Integer, Integer> edge : _adjacencies.get(i)) {
                System.out.print(edge.getFirst() + "(" + edge.getSecond() + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt();
        int edges = scanner.nextInt();
        int u, v, weight;

        AdjList adjList = new AdjList(nodes);

        int i = 0;
        while (i < edges) {
            u = scanner.nextInt() - 1;
            v = scanner.nextInt() - 1;
            weight = scanner.nextInt();
            adjList.addEdge(u, v, weight);
            ++i;
        }

        System.out.println("The Adjacency List -");
        adjList.printAdjacencies();

        System.out.println("Remove - " + adjList.removeEdge(2, new Pair(3, 2)));

        System.out.println("The Adjacency List - ");
        adjList.printAdjacencies();

        System.out.println(adjList.hasEdge(2, 3, 2));
    }
}

