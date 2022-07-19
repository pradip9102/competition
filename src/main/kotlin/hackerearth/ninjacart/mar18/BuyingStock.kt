package hackerearth.ninjacart.mar18

class BuyingStock(private val nDay: Int, private val diffs: IntArray) {

    fun maxSubArraySum(): Long {
        var maxSoFar = 0L //Long.MIN_VALUE
        var maxEndingHere = 0L

        for (i in 0 until nDay) {
            maxEndingHere += diffs[i]

            if (maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere

            if (maxEndingHere < 0)
                maxEndingHere = 0
        }

        return maxSoFar
    }
}

fun main() {
    fun readIntArray(): IntArray {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()
    }

    val pchef = BuyingStock(readLine()!!.toInt(), readIntArray())
    println(pchef.maxSubArraySum())
}