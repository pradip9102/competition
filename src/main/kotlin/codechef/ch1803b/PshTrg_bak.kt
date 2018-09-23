package codechef.ch1803b

class PshTrg_bak(private val sequence: IntArray) {
    private fun isValidTriangle(a: Int, b: Int, c: Int) = Math.abs(a - b) < c && c < Math.abs(a + b)

    fun set(pos: Int, value: Int) {
        sequence[pos - 1] = value
    }

    fun getMaxPerimeter(l: Int, r: Int): Long {
        var maxPerimeter = 0L
        for (i in (l - 1)..(r - 3)) {
            for (j in (i + 1)..(r - 2)) {
                ((j + 1)..(r - 1))
                        .asSequence()
                        .filter { k -> isValidTriangle(sequence[i], sequence[j], sequence[k]) }
                        .map { k -> sequence[i].toLong() + sequence[j].toLong() + sequence[k].toLong() }
                        .filter { maxPerimeter < it }
                        .forEach { maxPerimeter = it }
            }
        }
        return maxPerimeter
    }
}

fun main(args: Array<String>) {
    fun readIntArray(): IntArray {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()
    }

    val line1 = readIntArray()
    val pchef = PshTrg_bak(readIntArray())
    (0 until line1[1]).forEach {
        val query = readIntArray()
        when (query[0]) {
            1 -> pchef.set(query[1], query[2])
            2 -> println(pchef.getMaxPerimeter(query[1], query[2]))
        }
    }
}