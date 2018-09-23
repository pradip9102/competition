package thoughtworks

class DigitsInANumber {
    companion object {
        fun totalNumbersWithinDigit(n: Int) = ((Math.pow(3.toDouble(), n.toDouble()).toLong() - 1) shr 1) - 1
    }
}

fun main(args: Array<String>) {
    val digitCounts by lazy {
        return@lazy (1..39).map { DigitsInANumber.totalNumbersWithinDigit(it) }
    }

    (0 until readLine()!!.toInt()).forEach {
        val num = readLine()!!.toLong()
        var result: Int = 0
        for (i in digitCounts.indices) {
            ++result
            if (num <= digitCounts[i]) {
                break
            }
        }
        println(result-1)
    }
}