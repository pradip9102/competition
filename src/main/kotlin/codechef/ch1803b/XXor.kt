package codechef.ch1803b

class XXor(elements: List<Int>) {
    private val MAX_BIT_POS = 31
    private val totalOnes = arrayListOf<IntArray>()

    init {
        totalOnes.add(sum(IntArray(MAX_BIT_POS, { 0 }), elements[0]))
        (1 until elements.size).forEach { i -> totalOnes.add(i, sum(totalOnes[i - 1], elements[i])) }
    }

    private fun sum(array: IntArray, num: Int) = (0 until array.size).map { i -> array[i] + (if (num and (1 shl i) > 0) 1 else 0) }.toIntArray()

    fun countOnes(li: Int, ri: Int) = (0 until MAX_BIT_POS).map { bi -> countOnes(li, ri, bi) }

    private fun countOnes(li: Int, ri: Int, bi: Int) = if (li == 0) totalOnes[ri][bi] else (totalOnes[ri][bi] - totalOnes[li - 1][bi])
}

fun main(args: Array<String>) {
    fun readIntArray(): List<Int> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    val line1 = readIntArray()
    val nQuery = line1[1]
    val pchef = XXor(readIntArray())
    (0 until nQuery).forEach {
        val query = readIntArray()
        val li = query[0] - 1
        val ri = query[1] - 1
        val length = ri - li + 1

        var result = 0
        pchef.countOnes(query[0] - 1, query[1] - 1).forEachIndexed { i, nOne ->
            val nZero = length - nOne
            if (nZero > nOne) {
                result = result or (1 shl i)
            }
        }
        println(result)
    }
}