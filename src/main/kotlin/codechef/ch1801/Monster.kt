package codechef.ch1801

class Monster {
}

fun main(args: Array<String>) {
    fun readIntArray(): List<Int> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    val n = readLine()!!.toInt()
    val h = readIntArray()
    (0 until readLine()!!.toInt()).forEach {
        val line = readIntArray()
        val x = line[0]
        val y = line[1]
    }
}