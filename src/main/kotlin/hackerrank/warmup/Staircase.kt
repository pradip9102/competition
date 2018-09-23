package hackerrank.warmup

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLine().trim().toInt()
    for (i in 1..n) {
        for (j in 1..n) {
            print(if (j > n - i) "#" else " ")
        }
        println()
    }
}