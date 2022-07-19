package thoughtworks

class DigitsInANumber {
    companion object {
        fun totalNumbersWithinDigit(n: Int) = ((Math.pow(3.toDouble(), n.toDouble()).toLong() - 1) shr 1) - 1
    }
}

fun main() {
    val digitCounts by lazy {
        return@lazy (1..39).map { DigitsInANumber.totalNumbersWithinDigit(it) }
    }

    repeat(readLine()!!.toInt()) {
        val num = readLine()!!.toLong()
        var result = 0
        for (i in digitCounts.indices) {
            ++result
            if (num <= digitCounts[i]) {
                break
            }
        }
        println(result - 1)
    }
}
