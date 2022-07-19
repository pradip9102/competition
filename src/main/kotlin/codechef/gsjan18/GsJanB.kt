package codechef.gsjan18

import kotlin.math.abs

fun main() {
    fun readIntArray(): List<Int> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    repeat(readLine()!!.toInt()) {
        val n = readLine()!!.toInt()
        var diff = 0L

        repeat(n) {
            val array = readIntArray()
            var max = 0
            var min = Int.MAX_VALUE

            (0 until n).forEach { i ->
                if (max < array[i]) {
                    max = array[i]
                }

                if (min > array[i]) {
                    min = array[i]
                }
            }

            diff += abs(max - min)
        }

        println(diff)
    }
}