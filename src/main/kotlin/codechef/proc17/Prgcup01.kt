package codechef.proc17

class Prgcup01 {
    companion object {
        fun minMoves(f1: Int, r1: Int, f2: Int, r2: Int): Int {
            when {
                f1 < 1 || f1 > 8 || r1 < 1 || r1 > 8 -> return Int.MAX_VALUE
                f1 == f2 && r1 == r2 -> return 0
                else -> {
                    val option1 = minMoves(f1 - 1, r1 + 2, f2, r2)
                    val option2 = minMoves(f1 + 1, r1 + 2, f2, r2)

                    val option3 = minMoves(f1 + 2, r1 - 1, f2, r2)
                    val option4 = minMoves(f1 + 2, r1 + 1, f2, r2)

                    val option5 = minMoves(f1 + 1, r1 - 2, f2, r2)
                    val option6 = minMoves(f1 - 1, r1 - 2, f2, r2)

                    val option7 = minMoves(f1 - 2, r1 - 1, f2, r2)
                    val option8 = minMoves(f1 - 2, r1 + 1, f2, r2)

                    return minOf(option8, minOf(option7, minOf(option6, minOf(option5, minOf(option4, minOf(option3, minOf(option2, option1)))))))
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    (0 until readLine()!!.toInt()).forEach {
        val line = readLine()!!.split(" ").filter { it.isNotEmpty() }
        val f1 = line[0][0].toInt() - 'a'.toInt() + 1
        val r1 = line[0][1].toInt() - '1'.toInt() + 1
        val f2 = line[1][0].toInt() - 'a'.toInt() + 1
        val r2 = line[1][1].toInt() - '1'.toInt() + 1

        println(Prgcup01.minMoves(f1, r1, f2, r2))
    }
}