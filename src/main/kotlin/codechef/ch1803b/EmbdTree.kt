package codechef.ch1803b


data class Node(
        val id: Int,
        var x: Int = 0,
        var y: Int = 0,
        var isPlaced: Boolean = false,
        var count: Int = 0
)

data class Edge(
        val node1: Node,
        val node2: Node,
        val minLength: Int
)

class EmbdTree(val nNode: Int) {
    val nodes = List(nNode, { i -> Node(i) })
    val edges = arrayListOf<Edge>()

    fun addEdge(edge: Edge) {
        edges.add(edge)
        ++edge.node1.count
        ++edge.node2.count
    }

    fun findFirstNode() = nodes.first { it.count == 1 }

    fun buildTree() {
    }

    fun getDistance(node1: Node, node2: Node): Double {
        val deltaX = (node1.x - node2.x).toDouble()
        val deltaY = (node1.y - node2.y).toDouble()
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY)
    }
}

fun main() {
    fun readIntArray(): IntArray {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()
    }

    val pchef = EmbdTree(readLine()!!.toInt())
    repeat(pchef.nNode) {
        val line = readIntArray()
        pchef.addEdge(Edge(pchef.nodes[line[0] - 1], pchef.nodes[line[1] - 1], line[2]))
    }

    pchef.buildTree()
}