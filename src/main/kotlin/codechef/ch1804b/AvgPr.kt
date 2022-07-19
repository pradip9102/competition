package codechef.ch1804b

fun main() {
    fun readIntList(delimiter: String = " "): List<Int> {
        return readLine()!!.split(delimiter).filter { it.isNotEmpty() }.map { it.toInt() }
    }

    repeat(readLine()!!.toInt()) {
        readLine()!!.toInt()
        val sequence = readIntList()

        val evens = mutableListOf<Int>()
        val odds = mutableListOf<Int>()
        val counts = hashMapOf<Int, Int>()
        sequence.forEach {
            if (it % 2 == 0) {
                evens.add(it)
            } else {
                odds.add(it)
            }

            if (counts[it] == null) {
                counts[it] = 1
            } else {
                counts[it] = counts[it]!! + 1
            }
        }

        var result = 0
        result = countAvg(evens, counts, result)
        result = countAvg(odds, counts, result)

        println(result)
    }
}

private fun countAvg(evens: MutableList<Int>, counts: HashMap<Int, Int>, result: Int): Int {
    var result1 = result
    for (i in evens.indices) {
        for (j in evens.indices.filter { it > i }) {
            val avg = (evens[i] + evens[j]) / 2
            if (counts[avg] != null) {
                ++result1
            }
        }
    }
    return result1
}