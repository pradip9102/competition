package hackerearth.practo

class Reunion(private val bits: MutableList<Boolean>) {

    fun countMaxUnion(x: Int = 0): Int = when {
        x < 0 -> 0
        x > bits.size -> 0
        x == 0 -> {
            var globalMax = 0
            var i = 1

            while (i <= bits.size) {
                val localMax = countMaxUnion(i)
                if (localMax > globalMax) {
                    globalMax = localMax
                }
                i += localMax + 1
            }

            globalMax
        }
        else -> {
            var start = x - 1
            while ((start >= 0) && bits[start]) {
                start = start.dec()
            }

            var end = x - 1
            while ((end < bits.size) && bits[end]) {
                end = end.inc()
            }

            if (start == end) 0 else (end - start - 1)
        }
    }
}

fun main(args: Array<String>) {
    var n = 0
    var k = 0
    readLine()!!
            .split(" ")
            .filter { it.isNotEmpty() }
            .forEachIndexed { i, param ->
                when (i) {
                    0 -> n = param.toInt()
                    1 -> k = param.toInt()
                    else -> println("Error: Expected 0<=i<=1, but found i=$i")
                }
            }

    var bits = readLine()!!
            .asSequence()
            .map { it == '1' }
            .toMutableList()

    val problem = Reunion(bits)
    var globalMax = problem.countMaxUnion()

    (1..k).forEach {
        // read query
        val query = readLine()!!
                .split(" ")
                .filter { it.isNotEmpty() }
                .map { it.toInt() }
                .toList()

        when (query[0]) {
        // print global max
            1 -> println(globalMax)

        // mutate and recalculate global max
            2 -> {
                bits[query[1] - 1] = true
                val localMax = problem.countMaxUnion(query[1])
                if (localMax > globalMax) {
                    globalMax = localMax
                }
            }
        }
    }
}