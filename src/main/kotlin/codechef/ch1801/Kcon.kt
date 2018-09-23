package codechef.ch1801

class Kcon {
}

fun main(args: Array<String>) {
    fun readIntArray(): List<Int> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    fun kadenceSumCircular(a: List<Int>): Long {
        var maxSoFar = Long.MIN_VALUE
        var maxEndingHere = 0L

        var start = 0
        var end = 0
        while (start < a.size && (end - start) < a.size) {
            val effIndex = end % a.size
            maxEndingHere += a[effIndex]

            // update global max
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere
            }

            // update local max
            if (maxEndingHere < 0) {
                start = end
                maxEndingHere = 0
            }

            // increase index
            ++end
        }

        return maxSoFar
    }

    fun kadenceSumLinear(a: List<Int>): Long {
        var maxSoFar = Long.MIN_VALUE
        var maxEndingHere = 0L

        (0 until a.size).forEach { effIndex ->
            maxEndingHere += a[effIndex]

            // update global max
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere
            }

            // update local max
            if (maxEndingHere < 0) {
//                start = end
                maxEndingHere = 0
            }
        }

        return maxSoFar
    }

    (0 until readLine()!!.toInt()).forEach {
        val line1 = readIntArray()
        val n = line1[0]
        val k = line1[1]
        val a = readIntArray()

        val sumOfA = a.map { it.toLong() }.sum()
        val kLinear = kadenceSumLinear(a)
        val kCircular = kadenceSumCircular(a)

        val max1 = sumOfA * k
        val max2 = kLinear
        val max3 = if (k > 1) sumOfA * (k - 1) + kLinear else Long.MIN_VALUE
        val max4 = if (k > 1) kCircular else Long.MIN_VALUE
        val max5 = if (k > 2) sumOfA * (k - 2) + kCircular else Long.MIN_VALUE

//        println("max1: $max1")
//        println("max2: $max2")
//        println("max3: $max3")
//        println("max4: $max4")
        var max = if (max1 > max2) max1 else max2
        max = if (max > max3) max else max3
        max = if (max > max4) max else max4
        max = if (max > max5) max else max5
        println(max)
    }
}