import java.util.*

class AdjacencyList(nodeCount: Int = 0) {
    private val _adjacencies = arrayListOf<LinkedList<Pair<Int, Int>>>()

    init {
        repeat(nodeCount) {
            _adjacencies.add(LinkedList())
        }
    }

    fun addEdge(startNode: Int, endNode: Int, weight: Int) {
        _adjacencies[startNode].add(Pair(endNode + 1, weight))
    }

    fun countNodes(): Int {
        return _adjacencies.size
    }

    fun countEdgesFrom(startNode: Int): Int {
        return _adjacencies[startNode].size
    }

    fun getEdgesFrom(startNode: Int): LinkedList<Pair<Int, Int>> {
        return LinkedList(_adjacencies[startNode])
    }

    fun removeEdge(startNode: Int, edge: Pair<Int, Int>): Boolean {
        return _adjacencies[startNode - 1].remove(edge)
    }

    fun hasEdge(startNode: Int, endNode: Int, weight: Int): Boolean {
        return _adjacencies[startNode].contains(Pair(endNode, weight))
    }

    fun printAdjacencies() {
        for ((i, list) in _adjacencies.withIndex()) {
            print("adjacencies[${i + 1}] -> ")
            for (edge in list) {
                print("${edge.first}(${edge.second}) ")
            }
            println()
        }
    }
}

fun main() {
    val s = Scanner(System.`in`)

    val nodes = s.nextInt()
    val edges = s.nextInt()
    var u: Int
    var v: Int
    var weight: Int

    val adjacencyList = AdjacencyList(nodes)

    var i = 0

    while (i < edges) {
        u = s.nextInt() - 1
        v = s.nextInt() - 1
        weight = s.nextInt()

        adjacencyList.addEdge(u, v, weight)
        ++i
    }

    println("The Adjacency List -")
    adjacencyList.printAdjacencies()

    println("Remove - " + adjacencyList.removeEdge(2, Pair(3, 2)))

    println("The Adjacency List -")
    adjacencyList.printAdjacencies()

    println(adjacencyList.hasEdge(2, 3, 2))
}