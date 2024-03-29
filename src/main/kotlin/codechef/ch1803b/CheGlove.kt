package codechef.ch1803b

fun main() {
    fun readIntArray(): List<Int> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    repeat(readLine()!!.toInt()) {
        val nFinger = readLine()!!.toInt()
        val fingerLengths = readIntArray()
        val sheathLengths = readIntArray()

        var front = true
        var back = true

        (0 until nFinger).forEach { i ->
            if (front) {
                front = fingerLengths[i] <= sheathLengths[i]
            }
            if (back) {
                back = fingerLengths[i] <= sheathLengths[nFinger - i - 1]
            }
        }

        if (front && back) println("both")
        else if (front) println("front")
        else if (back) println("back")
        else println("none")
    }
}