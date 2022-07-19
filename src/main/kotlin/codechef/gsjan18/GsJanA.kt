package codechef.gsjan18

fun main() {
    fun readLongArray(): List<Long> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toLong() }
    }

    repeat(readLine()!!.toInt()) {
        val weights = readLongArray()
        var found = false
        (1..4).forEach { i ->
            if (weights[0] == weights[i]) {
                found = true
            }
        }

        println(if (found) "YES" else "NO")
    }
}