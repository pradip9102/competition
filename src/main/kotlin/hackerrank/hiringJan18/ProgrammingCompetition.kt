package hackerrank.hiringJan18

fun main(args: Array<String>) {
    fun readArray(): List<String> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }
    }

    var winnerAns = -1
    var winnerName = ""
    (0 until readLine()!!.toInt()).forEach {
        val line = readArray()
        val ans = line[2].toInt() - line[1].toInt()
        if (ans > winnerAns) {
            winnerAns = ans
            winnerName = line[0]
        }
    }

    println("$winnerName $winnerAns")
}