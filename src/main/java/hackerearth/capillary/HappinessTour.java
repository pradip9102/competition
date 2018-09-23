package hackerearth.capillary;

import javafx.util.*;

import java.util.*;

public class HappinessTour {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int t = scanner.nextInt(); t > 0; t--) {
            int cityCount = scanner.nextInt();
            List<Integer> happiness = new ArrayList<>(cityCount);
            for (int i = 0; i < cityCount; i++) {
                happiness.add(scanner.nextInt());
            }

            int roadCount = scanner.nextInt();
            List<Integer> uCities = new ArrayList<>(roadCount);
            for (int i = 0; i < roadCount; i++) {
                uCities.add(scanner.nextInt()-1);
            }
            List<Integer> vCities = new ArrayList<>(roadCount);
            for (int i = 0; i < roadCount; i++) {
                vCities.add(scanner.nextInt()-1);
            }

            AdjList adjList = new AdjList(cityCount);
            for (int i = 0; i < roadCount; i++) {
                adjList.addEdge(uCities.get(i), vCities.get(i), 0);
                adjList.addEdge(vCities.get(i), uCities.get(i), 0);
            }
            adjList.printAdjacencies();
        }
    }

    private static class AdjList {
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
                    System.out.print(edge.getKey() + "(" + edge.getValue() + ") ");
                }
                System.out.println();
            }
        }
    }
}
