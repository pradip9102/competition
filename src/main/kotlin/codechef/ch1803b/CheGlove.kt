package codechef.ch1803b

class CheGlove {
}

fun main(args: Array<String>) {
    fun readIntArray(): List<Int> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    (1..readLine()!!.toInt()).forEach {
        val nFinger = readLine()!!.toInt()
        val fingerLengths = readIntArray()
        val sheathLengths = readIntArray()

        var front = true
        var back = true

        (0..(nFinger - 1)).forEach { i ->
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