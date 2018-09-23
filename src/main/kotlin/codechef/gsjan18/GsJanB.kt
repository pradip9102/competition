package codechef.gsjan18

class GsJanB {
}

fun main(args: Array<String>) {
    fun readIntArray(): List<Int> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    (0 until readLine()!!.toInt()).forEach {
        val n = readLine()!!.toInt()
        var diff = 0L

        (0 until n).forEach {
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

            diff += Math.abs(max - min)
        }

        println(diff)
    }
}