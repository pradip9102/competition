package hackerearth.januaryCircuits18

fun main() {
    fun readIntArray(): List<Int> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    val line = readIntArray()
    val n = line[0]
    val k = line[1]
    val q = n / k
    val r = n % k

    val ans1 = (q.toLong() * (q + 1).toLong()) / 2
    val ans2 = (q.toLong() * (q - 1).toLong()) / 2
    val ans = ans1 * r + ans2 * (k - r)

    println(ans)
}