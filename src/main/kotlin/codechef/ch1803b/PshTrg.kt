package codechef.ch1803b

class PshTrg(private val sides: IntArray) {

    var leftSortedIndex = 0
    var rightSortedIndex = 0
    var lastSortedArray = IntArray(0)
    private fun isValidTriangle(a: Int, b: Int, c: Int) = Math.abs(a - b) < c && c < Math.abs(a + b)

    fun set(pos: Int, value: Int) {
        sides[pos - 1] = value
    }

    fun getMaxPerimeter(l: Int, r: Int): Long {
        // triangle is not possible
        if (r - l < 2) return 0

        // sort target sides
        val li = l - 1
        val ri = r - 1
        val targetSides = sides.sliceArray(li..ri).sortedArrayDescending()

        // find max perimeter
        for (i in 0 until (targetSides.size - 2)) {
            for (j in (i + 1) until (targetSides.size - 1)) {
                val k = j + 1
                if (isValidTriangle(targetSides[i], targetSides[j], targetSides[k])) {
                    return targetSides[i].toLong() + targetSides[j].toLong() + targetSides[k].toLong()
                }
            }
        }

        // valid triangle is not found
        return 0
    }
}

fun main(args: Array<String>) {
    fun readIntArray(): IntArray {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()
    }

    val line1 = readIntArray()
    val pchef = PshTrg(readIntArray())
    (0 until line1[1]).forEach {
        val query = readIntArray()
        when (query[0]) {
            1 -> pchef.set(query[1], query[2])
            2 -> println(pchef.getMaxPerimeter(query[1], query[2]))
        }
    }
}