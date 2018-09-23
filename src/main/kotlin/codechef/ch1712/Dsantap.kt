package codechef.ch1712

class Dsantap {
    companion object {
        val END_COMMUNICATION = 0
        val TRAVEL_TO_HOUSE = 1
        val PUT_PRESENT_TO_BAG = 2
        val TAKE_PRESENT_FROM_BAG = 3

        fun squaredDistance(child1: Child, child2: Child): Int {
            val distX = child1.posX - child2.posX
            val distY = child1.posY - child2.posY
            return distX * distX + distY * distY
        }
    }
}

data class Child(
        val index: Int,
        val posX: Int,
        val posY: Int,
        val prevGift: Int,
        val currGift: Int,
        val isSanta: Boolean = false
)

class GiftBag(val capacity: Int, val distinctPresentCount: Int, val volumes: List<Int>) {
    val gifts = mutableListOf<Int>()
}

fun main(args: Array<String>) {
    (0 until readLine()!!.toInt()).forEach {
        val children = mutableListOf<Child>()

        // santa
        val line1 = readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
        val childCount = line1[0]
        // child[0] represents santa; after all santa likes to live among children :)
        children.add(Child(0, line1[3], line1[4], 0, 0, isSanta = true))

        // gift bag
        val giftsVolume = mutableListOf(0)
        giftsVolume.addAll(readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() })
        val giftBag = GiftBag(distinctPresentCount = line1[1], capacity = line1[2], volumes = giftsVolume)

        // children
        var maxDistance = 0
        (1..childCount).forEach { i ->
            val childDetails = readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
            children.add(Child(index = i, posX = childDetails[0], posY = childDetails[1], prevGift = childDetails[2], currGift = childDetails[3]))
            val distance = Dsantap.squaredDistance(children[0], children.last())
            if (distance > maxDistance) maxDistance = distance
        }
    }
}