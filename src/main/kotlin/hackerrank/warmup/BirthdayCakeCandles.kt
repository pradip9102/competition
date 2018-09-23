package hackerrank.warmup

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val age = scanner.nextLine().trim().toInt()
    val heights = scanner.nextLine().trim().split(" ").map { it.toInt() }

    var max = Int.MIN_VALUE
    var count = 0
    for (height in heights) {
        if (max < height) {
            max = height
            count = 1
        } else if (max == height) {
            ++count
        }
    }
    println(count)
}