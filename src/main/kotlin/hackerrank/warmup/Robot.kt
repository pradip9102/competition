package hackerrank.warmup

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val ne = scanner.nextLine().trim().toInt()
    val vs = arrayListOf<Int>()
    val ps = arrayListOf<Int>()
    repeat(ne) {
        val line = scanner.nextLine().trim().split(" ").map { it.toInt() }
        vs.add(line[0])
        ps.add(line[1])
    }
}