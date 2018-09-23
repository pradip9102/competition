package hackerrank.warmup

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val array = scanner.nextLine().trim().split(" ").map { it.toLong() }
    val total = array.sum()
    val min = array.min()!!
    val max = array.max()!!
    println("${total - max} ${total - min}")
}