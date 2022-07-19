package hackerrank.warmup

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val array = scanner.nextLine().trim().split(" ").map { it.toLong() }
    val total = array.sum()
    val min = array.minOrNull()!!
    val max = array.maxOrNull()!!
    println("${total - max} ${total - min}")
}