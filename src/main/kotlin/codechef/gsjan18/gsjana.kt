package codechef.gsjan18

class gsjana {
}

fun main(args: Array<String>) {
    fun readLongArray(): List<Long> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toLong() }
    }

    (0 until readLine()!!.toInt()).forEach {
        val weights = readLongArray();
        var found = false
        (1..4).forEach { i ->
            if (weights[0] == weights[i]) {
                found = true
            }
        }

        println(if (found) "YES" else "NO")
    }
}