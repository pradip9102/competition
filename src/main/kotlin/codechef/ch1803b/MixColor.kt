package codechef.ch1803b

fun main() {
    fun readIntArray(): List<Int> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    repeat(readLine()!!.toInt()) {
        readLine()!!.toInt()
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