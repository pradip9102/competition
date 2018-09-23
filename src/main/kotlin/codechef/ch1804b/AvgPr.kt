package codechef.ch1804b

class AvgPr {
}

data class Element(val value: Int, var count: Int)

fun main(args: Array<String>) {
    fun readIntList(delimiter: String = " "): List<Int> {
        return readLine()!!.split(delimiter).filter { it.isNotEmpty() }.map { it.toInt() }
    }

    (0 until readLine()!!.toInt()).forEach { t ->
        val len = readLine()!!.toInt()
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
        for (i in evens.indices) {
            for (j in evens.indices.filter { it > i }) {
                val avg = (evens[i] + evens[j]) / 2
                if (counts[avg] != null) {
                    ++result
                }
            }
        }
        for (i in odds.indices) {
            for (j in odds.indices.filter { it > i }) {
                val avg = (odds[i] + odds[j]) / 2
                if (counts[avg] != null) {
                    ++result
                }
            }
        }

        println(result)
    }
}