//package codechef.ch1712

fun main() {
    repeat(readLine()!!.toInt()) {
        val N = readLine()!!.toInt()

        val array = readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }

        var temp = -1
        var duplicateExists = false
        val sortedArray = array
            .mapIndexed { i, num -> i to num }
            .sortedBy { it.second }
            .map { pair ->
                if (!duplicateExists) {
                    if (temp > 0 && temp == pair.second) {
                        duplicateExists = true
                    }
                    temp = pair.second
                }
                pair
            }

        val shiftBy = if (duplicateExists) 2 else 1
        val result = array.toMutableList()
        var hammingDistance = 0
        (0 until N).forEach { i ->
            val j = sortedArray[i].first
            result[j] = sortedArray[(i + shiftBy) % N].second
            if (result[j] != array[j]) ++hammingDistance
        }

        println(hammingDistance)
        println(result.joinToString(" "))
    }
}