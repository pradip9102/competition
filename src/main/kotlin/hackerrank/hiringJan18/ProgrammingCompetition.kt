package hackerrank.hiringJan18

fun main() {
    fun readArray(): List<String> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }
    }

    var winnerAns = -1
    var winnerName = ""
    repeat(readLine()!!.toInt()) {
        val line = readArray()
        val ans = line[2].toInt() - line[1].toInt()
        if (ans > winnerAns) {
            winnerAns = ans
            winnerName = line[0]
        }
    }

    println("$winnerName $winnerAns")
}