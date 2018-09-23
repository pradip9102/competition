package hackerearth.samsungrnd

import java.util.*

class OddSumProblem {
}

fun main(args: Array<String>) {
    fun readInts() = readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }

    val length = readLine()!!.toInt()
    val array = readInts()
    val countMap = hashMapOf<Int, MutableList<Int>>()
    array.forEachIndexed { i, num ->
        if (!countMap.containsKey(num)) {
            countMap[num] = ArrayList()
        }

        countMap[num]?.add(i)
    }
    (0 until readLine()!!.toInt()).forEach { _ ->
        val query = readInts()
        val left = query[0]
        val right = query[1]
    }
}