package hackerrank.warmup

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val ne = scanner.nextLine().trim().toInt()
    val vs = arrayListOf<Int>()
    val ps = arrayListOf<Int>()
    (0 until ne).forEach {
        val line = scanner.nextLine().trim().split(" ").map { it.toInt() }
        vs.add(line[0])
        ps.add(line[1])
    }
}