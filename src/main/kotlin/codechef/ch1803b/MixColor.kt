package codechef.ch1803b

class MixColor {
}

fun main(args: Array<String>) {
    fun readIntArray(): List<Int> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    (1..readLine()!!.toInt()).forEach {
        val nColors = readLine()!!.toInt()
        val colorValues = readIntArray()
        var minOpCount = 0

        val flags = mutableMapOf<Int, Int>()

        for (colorValue in colorValues) {
            flags[colorValue] = 1 + if (flags[colorValue] == null) 0 else flags[colorValue]!!
            if (flags[colorValue]!! > 1) {
                ++minOpCount
            }
        }

        println(minOpCount)
    }
}